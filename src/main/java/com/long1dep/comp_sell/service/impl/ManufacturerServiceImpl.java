package com.long1dep.comp_sell.service.impl;

import com.long1dep.comp_sell.entity.Manufacturer;
import com.long1dep.comp_sell.repository.ManufacturerRepository;
import com.long1dep.comp_sell.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
//    @Autowired
    private final ManufacturerRepository manuRepo;

    public ManufacturerServiceImpl(ManufacturerRepository manuRepo) {
        this.manuRepo = manuRepo;
    }

    @Override
    public void saveManufacturer(Manufacturer m) {
        manuRepo.save(m);
    }

    @Override
    public List<Manufacturer> getAllManufacturer() {
        return manuRepo.findAll();
    }
}
