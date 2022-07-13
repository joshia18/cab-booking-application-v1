package com.aj.cabbookingapp.Controllers;

import com.aj.cabbookingapp.Exceptions.CabNotFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class CabsController {
    @Autowired
    private CabService cabService;

    @PostMapping("/cabs/add_driver")
    public Cab add_driver(@Valid @RequestBody Cab cab){
        return cabService.save(cab);
    }

    @PutMapping("/cabs/update_driverLocation/{driverName}")
    public Cab update_driverLocation(@PathVariable String driverName,
                                     @RequestBody Location location) throws CabNotFoundException {
        return cabService.update_location(driverName, location);
    }

    @PutMapping("cabs/change_driver_status/{driverName}")
    public Cab change_driver_status(@PathVariable String driverName,
                                    @RequestBody Cab cab) throws CabNotFoundException {
        return cabService.change_driver_status(driverName, cab);
    }

    @GetMapping("/cabs/find_total_earning")
    public Map<String, Double> find_total_earning(){
        return cabService.find_total_earning();
    }
}
