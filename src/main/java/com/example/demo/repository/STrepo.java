package com.example.demo.repository;

import com.example.demo.model.STModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STrepo extends JpaRepository<STModel,Long> {
}
