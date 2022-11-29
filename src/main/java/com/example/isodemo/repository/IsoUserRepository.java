package com.example.isodemo.repository;

import com.example.isodemo.model.IsoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  IsoUserRepository extends JpaRepository<IsoUser, Integer> {

    List<IsoUser> findByUsername(String username);



}
