package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.CabNotFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Location;

import java.util.Map;

public interface CabService {

    public Cab save(Cab cab);

    public Cab update_location(String driverName, Location location) throws CabNotFoundException;

    public Cab change_driver_status(String driverName, Cab cab) throws CabNotFoundException;

    public Map<String, Double> find_total_earning();
}
