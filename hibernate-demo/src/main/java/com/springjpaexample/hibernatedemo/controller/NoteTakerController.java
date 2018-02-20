package com.springjpaexample.hibernatedemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springjpaexample.hibernatedemo.model.Note;
import com.springjpaexample.hibernatedemo.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteTakerController {

    @Autowired
    NoteRepo repo;

    @RequestMapping("/notes")
    public List<Note> fetchAllNotes(){
        return repo.findAll();
    }

    @RequestMapping(value = "/createNote",method = RequestMethod.POST)
    public Note createNote( @RequestBody Note note){
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("Writing value :::: "+mapper.writeValueAsString(note));
        } catch (JsonProcessingException e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ");
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> "+note.toString());
        return repo.save(note);
    }
}
