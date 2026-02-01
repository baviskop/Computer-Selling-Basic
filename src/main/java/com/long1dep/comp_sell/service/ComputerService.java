package com.long1dep.comp_sell.service;

import com.long1dep.comp_sell.entity.Computer;

import java.util.List;

public interface ComputerService {
    public void saveComputer(Computer c);

    public List<Computer> showAllComputers();

    public Computer getComputerById(long id);

    public void deleteComputerById(long id);

    public void deleteComputer(Computer c);
}
