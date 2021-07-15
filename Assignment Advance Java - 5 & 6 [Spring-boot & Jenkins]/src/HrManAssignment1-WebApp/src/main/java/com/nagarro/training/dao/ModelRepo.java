package com.nagarro.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.demo.model.Model;

public interface ModelRepo extends JpaRepository<Model,Integer>
{
	
}
