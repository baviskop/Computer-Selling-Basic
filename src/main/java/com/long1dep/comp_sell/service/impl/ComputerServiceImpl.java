package com.long1dep.comp_sell.service.impl;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.repository.ComputerRepository;
import com.long1dep.comp_sell.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private ComputerRepository compRepo;
    @Override
    public void createComputer(Computer c) {
        compRepo.save(c);
    }
}
