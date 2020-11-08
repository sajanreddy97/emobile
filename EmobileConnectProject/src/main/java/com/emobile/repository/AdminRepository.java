package com.emobile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emobile.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

} 