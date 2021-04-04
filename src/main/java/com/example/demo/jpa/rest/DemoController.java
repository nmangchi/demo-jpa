package com.example.demo.jpa.rest;

import com.example.demo.jpa.model.Parent;
import com.example.demo.jpa.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/list")
    public ResponseEntity list() {
        List<Parent> parents = demoService.list();
        log.debug("Parents : {}", parents);
        return ResponseEntity.ok(parents);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Parent parent) {
        log.debug("parent : {}", parent);

        demoService.save(parent);

        return ResponseEntity.ok(parent);
    }

    @PutMapping("/save")
    public ResponseEntity update(@RequestBody Parent parent) {
        demoService.save(parent);

        return ResponseEntity.ok(parent);
    }
}
