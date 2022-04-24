package com.example.todo.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
    @Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    public SubjectModel subject;

    @Column(nullable = false, name = "topic",length = 1000)
    private String topic;
    @Column(nullable = false , name = "description")
    private String description;
    @Column(nullable = false)
    private String teacher;
    @Column(nullable = false)
    private Date date;
//    @Column(nullable = false)
//    private String subject;

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }



    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
