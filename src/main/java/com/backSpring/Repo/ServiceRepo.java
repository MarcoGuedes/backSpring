package com.backSpring.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backSpring.Models.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long>{
}
