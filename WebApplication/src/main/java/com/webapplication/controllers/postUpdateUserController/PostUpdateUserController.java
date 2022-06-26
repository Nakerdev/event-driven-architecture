package com.webapplication.controllers.postUpdateUserController;

import domain.modules.users.application.updateuser.AddPizzaRequestDto;
import domain.modules.users.application.updateuser.CreatePizzaRequest;
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
    public ModelAndView Execute(@ModelAttribute("addPizzaRequestDto") final AddPizzaRequestDto dto) {
        final var request = CreatePizzaRequest.create(dto);
        final var pizza = this.useCase.Execute(request);
        return new ModelAndView("backoffice/homeCQRS2/index", "pizzaResponseDto", new PizzaResponseDto(pizza));
    }
}