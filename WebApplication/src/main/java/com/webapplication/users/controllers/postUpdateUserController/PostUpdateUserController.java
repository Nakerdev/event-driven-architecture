package com.webapplication.users.controllers.postUpdateUserController;

import domain.modules.users.application.updateuser.UpdateUserRequest;
import domain.modules.users.application.updateuser.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class PostUpdateUserController {

    private final UpdateUserUseCase useCase;

    @Autowired
    public PostUpdateUserController(final UpdateUserUseCase command) {
        this.useCase = command;
    }

    @PostMapping("/updateUser")
    public ModelAndView execute(@ModelAttribute("addUserRequestDto") final AddUserRequestDto dto) {
        final var request = UpdateUserRequest.create(
                dto.getId(),
                dto.getName(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getAge()
        );
        final var user = this.useCase.execute(request);
        return new ModelAndView("/home/index", "userResponseDto", new UserResponseDto(user));
    }
}
