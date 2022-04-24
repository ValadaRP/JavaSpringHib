package com.example.todo.Services;

import com.example.todo.Models.SubjectModel;
import com.example.todo.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServices {
    @Autowired private SubjectRepository subjectRepository;

    public List<SubjectModel> listSubjectsAll(){
        return (List<SubjectModel>) subjectRepository.findAll();
    }

}
