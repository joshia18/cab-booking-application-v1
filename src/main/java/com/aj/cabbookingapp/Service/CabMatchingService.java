package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.NoCabsFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Location;

import java.util.List;

public interface CabMatchingService {
    public String find_ride(String userName) throws NoCabsFoundException;

    public void match_ride(String userName, String driverName, Location destination);

    public String calculate_bill(String userName);
}
