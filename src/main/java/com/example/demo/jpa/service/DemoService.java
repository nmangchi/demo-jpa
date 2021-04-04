package com.example.demo.jpa.service;

import com.example.demo.jpa.model.Parent;
import com.example.demo.jpa.repository.DemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DemoService {

    private final DemoRepository demoRepository;

    public void save(Parent parent) {
        demoRepository.save(parent);
    }

    public List<Parent> list() {
        List<Parent> parents = demoRepository.findAll();
        return parents;
    }
}
