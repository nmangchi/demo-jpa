package com.example.demo.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_id")
    private List<Child> childs = new ArrayList<>();

    public Parent(String name) {
        this.name = name;
    }

//    public void setChilds(List<Child> childs) {
//        childs.forEach(c -> c.setParent(this));
//        this.childs = childs;
//    }

    public Parent addChild(Child child) {
        if (this.childs.contains(child)) {
            this.childs.remove(child);
        }
        this.childs.add(child);
        child.setParent(this);
        return this;
    }
}
