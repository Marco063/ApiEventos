package com.edu.uptc.apieventos.controllers;

import com.edu.uptc.apieventos.entities.Assistant;
import com.edu.uptc.apieventos.entities.Event;
import com.edu.uptc.apieventos.responses.ResponseHandler;
import com.edu.uptc.apieventos.services.AssistantService;
import com.edu.uptc.apieventos.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssistantController {
    @Autowired
    private AssistantService assistantService;
    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findAll(@PathVariable Integer id){
        try {
            List<String> result = assistantService.findEmailsByEventsId(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@PathVariable Integer id, @RequestBody Assistant assistant){
        try {
            Event event = eventService.findById(id);
            if (event != null){
                Assistant result = assistantService.save(assistant,event);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
            }else{
                return ResponseHandler.generateResponse("Event not found", HttpStatus.NOT_FOUND,null);
            }
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
                Assistant assistant = assistantService.findById(id);
                assistantService.delete(assistant);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, assistant);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody Assistant assistant){
        try {
            Assistant result = assistantService.update(assistant);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
