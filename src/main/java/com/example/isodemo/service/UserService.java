package com.example.isodemo.service;

import com.example.isodemo.model.IsoUser;
import com.example.isodemo.repository.IsoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    IsoUserRepository isoUserRepository;

    public IsoUser getUser(int userid) {
        IsoUser isoUser;
        Optional<IsoUser> userOptional = isoUserRepository.findById(userid);

        if (userOptional.isPresent()) {
            isoUser = userOptional.get();
        } else {
            return null;
        }
        return isoUser;
    }

    public String createUser(IsoUser isoUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(isoUser.getPassword());
        isoUser.setPassword(encodedPassword);
        isoUserRepository.save(isoUser);
        return "register_success";
    }

    public String updateUser(IsoUser isoUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(isoUser.getPassword());
        isoUser.setPassword(encodedPassword);
        isoUserRepository.save(isoUser);
        return "user-updated";
    }

    public String deleteUser(int userId) {

        IsoUser isoUser;
        Optional<IsoUser> isoUserOptional = isoUserRepository.findById(userId);
        if (isoUserOptional.isPresent()) {
            isoUser = isoUserOptional.get();

        } else {
            return "User doesnt exist";
        }
        isoUserRepository.delete(isoUser);
        return "user deleted";

    }

    public List<IsoUser> displayUsers() {
        List<IsoUser> users = isoUserRepository.findAll();

        return users;

    }

    public IsoUser displayUser(String username) {
        List<IsoUser> foundUser = isoUserRepository.findByUsername(username);

        if (!foundUser.isEmpty() == true) {
            IsoUser isoUser = foundUser.get(0);

            return isoUser;
        }

        return null;
    }

}
