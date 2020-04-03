package ru.knasys.springinactioon5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.knasys.springinactioon5.entities.Order;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @GetMapping("/current")
    public String orderFrom(Model model){
        model.addAttribute("order", new Order());
        return "orderFrom";
    }

    @PostMapping("/current")
    public String processOrder(@Valid Order order, Errors errors){
        if(errors.hasErrors()){
            return "orderFrom";
        }
        log.info("Подтверждён ордер: " + order);
        return "redirect:/";
    }
}
