package com.long1dep.comp_sell.service.impl;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.repository.ComputerRepository;
import com.long1dep.comp_sell.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
//    @Autowired
    private final ComputerRepository compRepo;

    public ComputerServiceImpl(ComputerRepository compRepo) {
        this.compRepo = compRepo;
    }

    @Override
    public void saveComputer(Computer c) {
        compRepo.save(c);
    }

    @Override
    public List<Computer> showAllComputers() {
        return compRepo.findAll();
    }

    @Override
    public Computer getComputerById(long id) {
        return compRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteComputerById(long id) {
        compRepo.deleteById(id);
    }

    @Override
    public void deleteComputer(Computer c) {
        compRepo.delete(c);
    }
}
