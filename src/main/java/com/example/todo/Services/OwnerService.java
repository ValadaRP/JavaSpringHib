package com.example.todo.Services;

import com.example.todo.Models.Owner;
import com.example.todo.Models.SubjectModel;
import com.example.todo.Repositories.OwnerRepository;
import com.example.todo.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired private OwnerRepository ownerRepository;
    @Autowired private SubjectRepository subjectRepository;

    public List<Owner> listAll() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public List<SubjectModel> listSubjectsAll(){
        return (List<SubjectModel>) subjectRepository.findAll();
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    public void saveSubject(SubjectModel subjectModel){
        subjectRepository.save(subjectModel);
    }

    public Owner get(Integer id) throws OwnerNotFoundException {
        Optional<Owner> result = ownerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new OwnerNotFoundException("Nie znaleziono notatki o id: " + id);
    }

    public void delete(Integer id) throws OwnerNotFoundException {
        Long count = ownerRepository.count();
        if(count == 0 || count == null){
            throw new OwnerNotFoundException("Nie znaleziono notatki o id: " + id);
        }
        ownerRepository.deleteById(id);
    }
}
