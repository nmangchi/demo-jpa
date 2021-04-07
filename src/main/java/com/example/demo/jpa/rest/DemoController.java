package com.example.demo.jpa.rest;

import com.example.demo.jpa.model.Parent;
import com.example.demo.jpa.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/info/{id}")
    public ResponseEntity info(@PathVariable Long id) {
        Optional<Parent> parent = demoService.findByIdOrderByChildAgeDesc(id);

        return ResponseEntity.ok(parent);
    }

    @GetMapping("/parents/list")
    public ResponseEntity listParents() {
        List parents = demoService.findParentWithChild();

        return ResponseEntity.ok(parents);
    }
}
