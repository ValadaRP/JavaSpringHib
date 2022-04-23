package com.example.schronisko.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired private OwnerRepository ownerRepository;

    public List<Owner> listAll() {
        return (List<Owner>) ownerRepository.findAll();
    }
}
