package com.example.repositories;

import com.example.entities.Uom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomRepo extends JpaRepository<Uom, Long> {

}