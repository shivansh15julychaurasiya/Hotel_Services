package com.vijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
