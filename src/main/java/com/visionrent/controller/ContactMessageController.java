package com.visionrent.controller;


import com.visionrent.domain.ContactMessage;
import com.visionrent.dto.ContactMessageDTO;
import com.visionrent.dto.request.ContactMessageRequest;
import com.visionrent.dto.response.ResponseMessage;
import com.visionrent.dto.response.VRResponse;
import com.visionrent.mapper.ContactMessageMapper;
import com.visionrent.service.ContactMessageService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contactmessage")
@AllArgsConstructor
public class ContactMessageController {

    private ContactMessageMapper contactMessageMapper;

    private ContactMessageService contactMessageService;


    @PostMapping("/visitors")
    public ResponseEntity<VRResponse> createMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest){
        /*
         * Design PROBLEM -> this kind of service layer implementations should be done in service layer.
         */
        ContactMessage contactMessage = contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);
        contactMessageService.saveMessage(contactMessage);
        // as an example of HARD CODING
        //VRResponse response = new VRResponse("you made it",true);
        VRResponse response = new VRResponse(ResponseMessage.CONTACT_MESSAGE_SAVE_RESPONSE,true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //TODO please read about SQL-INJECTION

    @GetMapping
    public ResponseEntity<List<ContactMessageDTO>>getAllContactMessage(){
        List<ContactMessage>contactMessageList = contactMessageService.getAll();
        List<ContactMessageDTO>contactMessageDTOList = contactMessageMapper.map(contactMessageList);
        return ResponseEntity.ok(contactMessageDTOList);
    }




}
