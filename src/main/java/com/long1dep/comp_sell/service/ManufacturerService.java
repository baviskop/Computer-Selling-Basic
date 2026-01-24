package com.long1dep.comp_sell.service;

import com.long1dep.comp_sell.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    public void createManufacturer(Manufacturer m);
    public List<Manufacturer> getAllManufacturer();
}
