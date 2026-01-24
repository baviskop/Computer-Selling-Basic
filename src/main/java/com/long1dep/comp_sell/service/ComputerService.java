package com.long1dep.comp_sell.service;

import com.long1dep.comp_sell.entity.Computer;

import java.util.List;

public interface ComputerService {
    public void createComputer(Computer c);

    public List<Computer> showAllComputers();

    public Computer getComputerById(long id);
}
