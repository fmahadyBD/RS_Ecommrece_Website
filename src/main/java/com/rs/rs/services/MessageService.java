package com.rs.rs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.rs.dao.MessageRepository;
import com.rs.rs.models.Messages;

@Service
public class MessageService {
    @Autowired
    private final MessageRepository repository;

   
   
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Messages create(Messages messages) {
   
        return repository.save(messages);
    }
}
