package com.example.isodemo.controller;


import com.example.isodemo.model.IsoUser;
import com.example.isodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IsoUserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String displayHomepage(){
        return "index";
    }

    @GetMapping("/iso-users")
    public String showUsers(Model model) {

        return "iso-users";
    }

    @GetMapping("/view-users")
    public String listUsers(Model model) {
        List<IsoUser> listUsers = userService.displayUsers();
        model.addAttribute("listUsers", listUsers);

        return "signup_form";
    }

    @GetMapping("/adduser")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new IsoUser());

        return "addUserForm";
    }

    @GetMapping("/edit/{userid}")
    public String showUpdateForm(@PathVariable("userid") int userid, Model model) {
        IsoUser isoUser = userService.getUser(userid);

        model.addAttribute("user", isoUser);
        return "update-user";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Model model) {

        return "access-denied";
    }

    @PostMapping("/update/{userid}")
    public String updateUser(@PathVariable("userid") int userid, IsoUser isoUser,
                             BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            isoUser.setUserId(userid);
            return "update-user";
        }*/

        userService.updateUser(isoUser);

        return "register_success";
    }


    @PostMapping("/createUser")
    public String createIsoUser(IsoUser isoUser) {

        String employee = userService.createUser(isoUser);
        return "register_success";

    }

    /*@DeleteMapping(value = "/{userId}")
    public String deleteEmployee(@PathVariable("userId") Integer userId){

        String employee = userService.deleteUser(userId);
        return "update-user";

    }*/


}
