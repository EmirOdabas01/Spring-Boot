package com.example.HotelRoomProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelRoomProject.Entity.Room;

public interface RoomRepository extends JpaRepository <Room, Long>{
	
	List<Room>findByCustomerCustomerId(Long customerid);

}
