package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.NoCabsFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Journey;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Model.User;
import com.aj.cabbookingapp.Repository.CabRepository;
import com.aj.cabbookingapp.Repository.JourneyRepository;
import com.aj.cabbookingapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CabMatchingServiceImpl implements CabMatchingService {
    public static final Double MAX_ALLOWED_DISTANCE = 5.0;
    public static final Double PRICE_PER_UNIT = 1.0;
    @Autowired
    public CabRepository cabRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public JourneyRepository journeyRepository;

    @Override
    public String find_ride(String userName) throws NoCabsFoundException {
        User user = userRepository.findById(userName).get();

        Location from = user.getLocation();

        List<Cab> allCabs = cabRepository.findByIsAvailableTrue();
        TreeMap<Double, Cab> matchingCabs = new TreeMap<>();

        for(Cab cab : allCabs){
            if(from.getDistance(cab.getCurrentLocation()) <= MAX_ALLOWED_DISTANCE){
                matchingCabs.put(from.getDistance(cab.getCurrentLocation()), cab);
            }
        }

        if(matchingCabs.isEmpty()){
            throw new NoCabsFoundException("No ride found");
        }

        return matchingCabs.firstEntry().getValue().getDriverName();
    }

    @Override
    public void match_ride(String userName, String driverName, Location destination) {
        User user = userRepository.findById(userName).get();
        Cab cab = cabRepository.findById(driverName).get();

        Location userLocation = user.getLocation();

        Double bill = Math.ceil(userLocation.getDistance(destination)) * PRICE_PER_UNIT;

        Journey journey = Journey.builder().userName(userName).driverName(driverName)
                .start(userLocation).end(destination).bill(bill).build();

        //updating the location of both the user and the cab after the completion of ride
        cab.setEarning(cab.getEarning() + bill);
        user.setLocation(destination);
        cab.setCurrentLocation(destination);

        journeyRepository.save(journey);
        userRepository.save(user);
        cabRepository.save(cab);
    }

    @Override
    public String calculate_bill(String userName) {
        Double bill = journeyRepository.findById(userName).get().getBill();
        return "ride ended bill amount $" + bill;
    }

}
