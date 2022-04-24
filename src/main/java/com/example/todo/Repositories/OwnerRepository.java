package com.example.todo.Repositories;

import com.example.todo.Models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    public Long countById(Integer id);

}
