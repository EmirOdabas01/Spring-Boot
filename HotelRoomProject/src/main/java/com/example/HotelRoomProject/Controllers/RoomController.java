package com.example.HotelRoomProject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelRoomProject.Entity.Room;
import com.example.HotelRoomProject.Repository.RoomRepository;

@RestController
@RequestMapping("rooms")

public class RoomController {
	
	@Autowired
	RoomRepository roomRepo;
	
	@GetMapping("/list")
	List<Room> getRooms(){
		return roomRepo.findAll();
	}
	
	@GetMapping("/{roomid}")
	Optional<Room> getRoom(@PathVariable Long roomid) {	
		return roomRepo.findById(roomid);
	}
	
	@PostMapping("/new")
	String addNewRoom(@RequestBody Room room) {
		roomRepo.save(room);
		return "Room saved! The current number of room is " +roomRepo.count();
	}
	
	@GetMapping("/delete/{roomid}")
	String deleteRoom(@PathVariable Long roomid) {
		roomRepo.deleteById(roomid);
		return String.format("Room deleted " +roomid);
	}
	
	@GetMapping("/customer/{customerid}")
	List<Room> getRoomByCustomerId(@PathVariable Long customerid){
		return roomRepo.findByCustomerCustomerId(customerid);
	}
}
