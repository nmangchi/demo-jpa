package com.example.demo.jpa.repository;

import com.example.demo.jpa.model.Child;
import com.example.demo.jpa.model.Parent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@Slf4j
public class DemoRepositoryTests {

    @Autowired
    private DemoRepository demoRepository;

    @Test
    public void save() {

        Parent parent = new Parent("부모");
        parent.addChild(Child.builder().name("자식1").age(13).build());
        parent.addChild(Child.builder().name("자식2").age(22).build());

        demoRepository.save(parent);

        List<Parent> parents = demoRepository.findAll();
        for (Parent pa : parents) {
            log.debug("parent : {}", pa);
            log.debug("childs : {}", pa.getChilds());
        }

        parent.getChilds().remove(1);

        demoRepository.save(parent);

        parents = demoRepository.findAll();

        System.out.println("parent size : " + parents.size());
    }
}
