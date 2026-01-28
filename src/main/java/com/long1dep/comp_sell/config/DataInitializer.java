package com.long1dep.comp_sell.config;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.entity.Manufacturer;
import com.long1dep.comp_sell.entity.User;
import com.long1dep.comp_sell.service.ComputerService;
import com.long1dep.comp_sell.service.ManufacturerService;
import com.long1dep.comp_sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private ComputerService compService;
//    @Autowired
//    private ManufacturerService manufacturerService;
    private final UserService userService;
    private final ComputerService compService;
    private final ManufacturerService manufacturerService;

    public DataInitializer(UserService userService, ComputerService compService, ManufacturerService manufacturerService) {
        this.userService = userService;
        this.compService = compService;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("admin@gmail.com", "@1", "Admin");
        User u2 = new User("staff@gmail.com", "@2", "Staff");
        User u3 = new User("member@gmail.com", "@3", "Member");

        Manufacturer manu1 = new Manufacturer("Dell", "USA");
        Manufacturer manu2 = new Manufacturer("Lenovo", "China");
        Manufacturer manu3 = new Manufacturer("HP", "USA");

        Computer comp1 = new Computer("XPS 13", "Ultrabook", 2023, 1299.99, manu1);
        Computer comp2 = new Computer("ThinkPad X1 Carbon", "Business Laptop", 2023, 1499.99, manu2);
        Computer comp3 = new Computer("Pavilion 15", "Consumer Laptop", 2022, 699.99, manu3);
        Computer comp4 = new Computer("Inspiron 14", "Budget Laptop", 2023, 549.99, manu1);

        userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);

        manufacturerService.saveManufacturer(manu1);
        manufacturerService.saveManufacturer(manu2);
        manufacturerService.saveManufacturer(manu3);

        compService.saveComputer(comp1);
        compService.saveComputer(comp2);
        compService.saveComputer(comp3);
        compService.saveComputer(comp4);
    }
}
