package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.CabNotFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CabServiceImpl implements CabService{
    @Autowired
    private CabRepository cabRepository;

    @Override
    public Cab save(Cab cab) {
        return cabRepository.save(cab);
    }

    @Override
    public Cab update_location(String driverName, Location location) throws CabNotFoundException {
        Optional<Cab> dbCab = cabRepository.findById(driverName);

        if(!dbCab.isPresent()){
            throw new CabNotFoundException("Cab is Not Found");
        }

        Cab updatedCab = dbCab.get();
        if(Objects.nonNull(location)) updatedCab.setCurrentLocation(location);
        return cabRepository.save(updatedCab);
    }

    @Override
    public Cab change_driver_status(String driverName, Cab cab) throws CabNotFoundException {
        Optional<Cab> dbCab = cabRepository.findById(driverName);

        if(!dbCab.isPresent()){
            throw new CabNotFoundException("Cab is Not Found");
        }

        Cab updatedCab = dbCab.get();
        if(Objects.nonNull(cab.getIsAvailable())) updatedCab.setIsAvailable(cab.getIsAvailable());
        return cabRepository.save(updatedCab);
    }

    @Override
    public Map<String, Double> find_total_earning() {
        List<Cab> cabsList = cabRepository.findAll();

        Map<String, Double> earnings = new HashMap<>();

        for(Cab cab : cabsList){
            earnings.put(cab.getDriverName(), cab.getEarning());
        }

        return earnings;
    }
}
