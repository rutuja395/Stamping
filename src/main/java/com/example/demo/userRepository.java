package com.example.demo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<UserTable, Integer> {
	public List<UserTable> findAll();
	
	public UserTable findById(String s);
	

}
