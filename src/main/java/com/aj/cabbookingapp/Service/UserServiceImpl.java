package com.aj.cabbookingapp.Service;

import com.aj.cabbookingapp.Exceptions.UserNotFoundException;
import com.aj.cabbookingapp.Model.Location;
import com.aj.cabbookingapp.Model.User;
import com.aj.cabbookingapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update_user(String userName, User user) throws UserNotFoundException {
        Optional<User> dbUser = userRepository.findById(userName);

        if(!dbUser.isPresent()){
            throw new UserNotFoundException("User Not Found");
        }

        User updatedUser = dbUser.get();
        if(Objects.nonNull(user.getAge())) updatedUser.setAge(user.getAge());
        if(Objects.nonNull(user.getGender())) updatedUser.setGender(user.getGender());
        if(Objects.nonNull(user.getContact())) updatedUser.setContact(user.getContact());
        return userRepository.save(updatedUser);
    }

    @Override
    public User update_userLocation(String userName, Location location) throws UserNotFoundException {
        Optional<User> dbUser = userRepository.findById(userName);

        if(!dbUser.isPresent()){
            throw new UserNotFoundException("User Not Found");
        }

        User updatedUser = dbUser.get();
        if(Objects.nonNull(location)) updatedUser.setLocation(location);
        return userRepository.save(updatedUser);
    }
}
