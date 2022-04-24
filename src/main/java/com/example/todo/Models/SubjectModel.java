package com.example.todo.Models;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class SubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public Owner owner;

    public SubjectModel() {
    }

    @Column(nullable = false,name = "subject_name")
    public String subjectName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
