package org.example.repository.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "labworks", schema = "5sem")
public class LabWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labwork_id")
    private Integer id;

    @Column(name = "labwork_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "labwork")
    private Set<LabResult> labResults;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
