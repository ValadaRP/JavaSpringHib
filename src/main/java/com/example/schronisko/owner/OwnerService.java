package com.example.schronisko.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired private OwnerRepository ownerRepository;

    public List<Owner> listAll() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    public Owner get(Integer id) throws OwnerNotFoundException {
        Optional<Owner> result = ownerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new OwnerNotFoundException("Nie znaleziono właściciela o id: " + id);
    }

    public void delete(Integer id) throws OwnerNotFoundException {
        Long count = ownerRepository.count();
        if(count == 0 || count == null){
            throw new OwnerNotFoundException("Nie znaleziono właściciela o id: " + id);
        }
        ownerRepository.deleteById(id);
    }
}
