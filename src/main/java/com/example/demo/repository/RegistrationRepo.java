package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.demo.model.Registration;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{
	@Query(value = "SELECT * FROM Registration ORDER BY transaction_id", nativeQuery = true)
	public List<Registration> sortbytid();
	@Transactional
	@Modifying
	@Query(value="delete from Registration where transaction_id= :para",nativeQuery = true )
	public void deletemebyid(@Param("para") int id);

	@Transactional
	@Modifying
	@Query(value="update donors set address = 'updated street' where donor_id=6",nativeQuery = true )
	public void updatebyq();
	
}