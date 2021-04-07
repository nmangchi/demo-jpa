package com.example.demo.jpa.repository;

import com.example.demo.jpa.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Parent, Long>, DemoCustomRepository {

}
