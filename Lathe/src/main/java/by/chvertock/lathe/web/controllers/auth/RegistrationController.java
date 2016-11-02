package by.chvertock.lathe.web.controllers.auth;

import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.RoleType;
import by.chvertock.lathe.model.entities.user.User;
import by.chvertock.lathe.service.user.UserService;
import by.chvertock.lathe.util.StringUtils;
import by.chvertock.lathe.web.controllers.Encoder;
import by.chvertock.lathe.web.controllers.util.RegExpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private Encoder encoder;

    @RequestMapping(value = "/registration")
    public String showRegistrationForm(){
        return "registration";
    }

    @RequestMapping(value = "/registration-check")
    public ModelAndView registrationCheck(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "phoneNumber", required = true) String phoneNumber,
            HttpServletRequest request
    ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/shop/products");

        List<String> errors = new ArrayList<String>();

        if (StringUtils.isBlank(email)) {
            errors.add("Email can not be empty or blank");
        } else {
            modelAndView.addObject("email", email);
        }

        if (StringUtils.isBlank(password)) {
            errors.add("Password can not be empty or blank");
        } else {
            modelAndView.addObject("password", password);
        }

        // not required
        modelAndView.addObject("name", name);


        if (StringUtils.isBlank(address)) {
            errors.add("Address can not be empty or blank");
        } else {
            modelAndView.addObject("address", address);
        }

        if (StringUtils.isBlank(phoneNumber)) {
            errors.add("Phone number can not be empty or blank");
        } else {

            if(RegExpUtils.isValidPhoneNumber(phoneNumber)){
                modelAndView.addObject("phoneNumber", phoneNumber);
            } else {
                errors.add("Phone number is not valid");
            }
        }

        if (!errors.isEmpty()){
            modelAndView.addObject("errors", errors);

            modelAndView.setViewName("registration");

            return modelAndView;
        }

        User user = userService.getUserByEMail(email);

        if (user != null) {
            errors.add("Email is already registered");

            modelAndView.addObject("errors", errors);

            modelAndView.setViewName("registration");

            return modelAndView;
        }

        String rawPassword = password;//generatePassword();
        String encPassword = encoder.encode(rawPassword);

        System.out.println(rawPassword);
        System.out.println(encPassword);

        user = new User();
        user.setEmail(email);
        user.setPassword(encPassword);
        user.setName(name);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.addRole(new Role(RoleType.ROLE_CUSTOMER));

        userService.addUser(user);

        // login after registration successful
        try {
            request.login(user.getEmail(), rawPassword);
        } catch (ServletException e) {
            // TODO: log

            throw new RuntimeException(e);
        }

        return modelAndView;
    }

    private String generatePassword() {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ1234567890";

        Random random = new Random();

        StringBuilder pass = new StringBuilder();

        for (int i = 0; i < 5; ++i) {
            int index = random.nextInt(letters.length());
            pass.append(letters.charAt(index));
        }

        return pass.toString();
    }
}
