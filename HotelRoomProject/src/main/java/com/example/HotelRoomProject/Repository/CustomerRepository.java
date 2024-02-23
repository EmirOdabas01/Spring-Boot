package com.example.HotelRoomProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelRoomProject.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
