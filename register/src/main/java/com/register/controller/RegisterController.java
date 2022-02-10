package com.register.controller;


import com.register.dto.RegisterDto;
import com.register.entity.RegisterEntity;
import com.register.repository.RegisterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class RegisterController {
    @Autowired
    RegisterRepository registerRepository;

    // http://localhost:8080/register
    @GetMapping("/register")
    public String getForm(Model model)
    {
        model.addAttribute("key_form", new RegisterDto());
        return "register";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postForm(@Valid @ModelAttribute("key_form") RegisterDto dto, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            log.error("hata var");
            log.info(dto);
            return "register";
        }
        else{
            RegisterEntity registerEntity=RegisterEntity.builder()
                    .id(0L)
                    .userName(dto.getUserName())
                    .userSurname(dto.getUserSurname())
                    .userEmail(dto.getEmailAddress())
                    .build();

            registerRepository.save(registerEntity);
            log.info(dto);
            return "redirect";
        }


    }
}
