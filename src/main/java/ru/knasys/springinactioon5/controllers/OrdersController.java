package ru.knasys.springinactioon5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.knasys.springinactioon5.db.OrderRepository;
import ru.knasys.springinactioon5.entities.Order;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrdersController {
    private OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderFrom(Model model){
//        model.addAttribute("order", new Order());
        return "orderFrom";
    }

    @PostMapping("/current")
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderFrom";
        }
        log.info("Подтверждён ордер: " + order);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping // обрабатываем просто /orders
    public String showOrders(Model model){

        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);

        model.addAttribute(orders);

        return "showOrders";
    }
}
