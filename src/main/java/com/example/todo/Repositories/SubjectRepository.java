package com.example.todo.Repositories;

import com.example.todo.Models.SubjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<SubjectModel,Integer> {

}
