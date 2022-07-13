package com.aj.cabbookingapp.Controllers;

import com.aj.cabbookingapp.Exceptions.NoCabsFoundException;
import com.aj.cabbookingapp.Exceptions.UserNotFoundException;
import com.aj.cabbookingapp.Model.Cab;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Model.User;
import com.aj.cabbookingapp.Service.CabMatchingService;
import com.aj.cabbookingapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private CabMatchingService cabMatchingService;

    @PostMapping("/users/add_user")
    public User add_user(@Valid @RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/users/update_user/{userName}")
    public User update_user(@PathVariable String userName,
                            @RequestBody User user) throws UserNotFoundException {
        return userService.update_user(userName, user);
    }

    @PutMapping("/users/update_userLocation/{userName}")
    public User update_userLocation(@PathVariable String userName,
                                     @RequestBody Location location) throws UserNotFoundException {
        return userService.update_userLocation(userName, location);
    }

    @GetMapping("/users/find_ride/{userName}")
    public String find_ride(@PathVariable String userName) throws NoCabsFoundException {
        return cabMatchingService.find_ride(userName);
    }

    @PutMapping("/users/choose_ride/{userName}")
    public String choose_ride(@PathVariable String userName, @RequestBody Location destination) throws NoCabsFoundException {
        String driverName = cabMatchingService.find_ride(userName);
        cabMatchingService.match_ride(userName, driverName, destination);
        return "ride started";
    }

    @GetMapping("/users/calculate_bill/{userName}")
    public String calculate_bill(@PathVariable String userName){
        return cabMatchingService.calculate_bill(userName);
    }

}
