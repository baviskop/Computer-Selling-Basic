package com.long1dep.comp_sell.service.impl;

import com.long1dep.comp_sell.entity.Manufacturer;
import com.long1dep.comp_sell.repository.ManufacturerRepository;
import com.long1dep.comp_sell.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manuRepo;
    @Override
    public void createManufacturer(Manufacturer m) {
        manuRepo.save(m);
    }
}
