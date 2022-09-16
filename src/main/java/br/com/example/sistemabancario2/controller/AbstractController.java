package br.com.example.sistemabancario2.controller;

import br.com.example.sistemabancario2.error.ResourceNotFoundException;
import br.com.example.sistemabancario2.model.Person;
import br.com.example.sistemabancario2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class AbstractController implements CrudRepository {
    
    public 

    @Autowired
    public AbstractController( dao) {
        this.dao = dao;
    }

    



}
