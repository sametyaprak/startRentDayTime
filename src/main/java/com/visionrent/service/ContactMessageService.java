package com.visionrent.service;

import com.visionrent.domain.ContactMessage;
import com.visionrent.exception.ResourceNotFoundException;
import com.visionrent.exception.message.ErrorMessage;
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

    public ContactMessage getContactMessage(Long id){
        ContactMessage contactMessage = contactMessageRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE,id));
    }

    public void deleteContactMessage(Long id){
        ContactMessage contactMessage =
    }


}
