package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.UserNotFoundException;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Model.User;

public interface UserService {

    public User save(User user);

    public User update_user(String userName, User user) throws UserNotFoundException;

    public User update_userLocation(String userName, Location location) throws UserNotFoundException;
}
