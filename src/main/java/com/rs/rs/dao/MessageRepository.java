package com.rs.rs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.rs.models.Messages;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
  
}
