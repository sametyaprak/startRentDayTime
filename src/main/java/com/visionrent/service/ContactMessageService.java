package com.visionrent.service;

import com.visionrent.domain.ContactMessage;
import com.visionrent.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageService {

    /**
     * this is a constructor injection example
     */
    private ContactMessageRepository contactMessageRepository;

    public void saveMessage(ContactMessage contactMessage){
        contactMessageRepository.save(contactMessage);
    }

    public List<ContactMessage>getAll(){
        return contactMessageRepository.findAll();
    }


}
