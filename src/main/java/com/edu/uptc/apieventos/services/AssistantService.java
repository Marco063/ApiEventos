package com.edu.uptc.apieventos.services;

import com.edu.uptc.apieventos.entities.Assistant;
import com.edu.uptc.apieventos.entities.Event;
import com.edu.uptc.apieventos.repositories.AssistantRepository;
import com.edu.uptc.apieventos.repositories.EventRepository;
import org.hibernate.tool.schema.internal.exec.AbstractScriptSourceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;

    public List<Assistant> findAll(){
        return  assistantRepository.findAll();
    }

    public Assistant findById(Integer id){
        Optional<Assistant> optional=assistantRepository.findById(id);
        return optional.isPresent() ? optional.get():null;
    }

    public List<String> findEmailsByEventsId(Integer eventId){
        return assistantRepository.findEmailsByEventId(eventId);
    }
    public Assistant save(Assistant assistant, Event event){
        assistant.setEvent(event);
        return  assistantRepository.save(assistant);
    }

    public void delete(Assistant assistant){
        if(assistant != null){
            assistantRepository.delete(assistant);
        }
    }


    public Assistant update(Assistant assistant){
        Optional<Assistant> existingAssistantOptional=assistantRepository.findById(assistant.getId());
        if(existingAssistantOptional.isPresent()){
            Assistant existingAssistant=existingAssistantOptional.get();
            existingAssistant.setName(assistant.getName());
            existingAssistant.setEmail(assistant.getEmail());
            if(assistant.getEvent() !=null){
                existingAssistant.setEvent(assistant.getEvent());
            }
            Assistant assistantUpdated=assistantRepository.save(assistant);
            return assistantUpdated;
        }
        return null;
    }





}
