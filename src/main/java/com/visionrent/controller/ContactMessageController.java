package com.visionrent.controller;


import com.visionrent.domain.ContactMessage;
import com.visionrent.dto.request.ContactMessageRequest;
import com.visionrent.mapper.ContactMessageMapper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {

    private ContactMessageMapper contactMessageMapper;

    @PostMapping("/visitors")
    public ResponseEntity<T> createMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest){

        ContactMessage contactMessage = contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);


        return null;
    }

}
