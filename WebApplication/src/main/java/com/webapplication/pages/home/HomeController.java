package com.webapplication.pages.home;

import com.webapplication.users.controllers.postUpdateUserController.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private UserRepository userRepository;

    @Autowired
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = {"/", "home"})
    public ModelAndView home(final Model model) {
        final var user = userRepository.SearchByUserId(2);
        if (user.isPresent()) {
            return new ModelAndView("/home/index", "userResponseDto",buildUserResponseDto(user.get()));
        } else {
            return new ModelAndView("/notFound/index", HttpStatus.NOT_FOUND);
        }
    }

    private UserResponseDto buildUserResponseDto(UserDto user) {
        return new UserResponseDto(
                user.getName(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge());
    }
}
