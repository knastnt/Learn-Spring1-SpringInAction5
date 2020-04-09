package ru.knasys.springinactioon5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.knasys.springinactioon5.db.OrderRepository;
import ru.knasys.springinactioon5.entities.Order;
import ru.knasys.springinactioon5.entities.User;

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
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderFrom";
        }
        log.info("Подтверждён ордер: " + order);
        order.setUser(user);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping // обрабатываем просто /orders
    public String showMyOrders(
            @AuthenticationPrincipal User user,
            Model model,
            @RequestParam(name = "zip", required = false) String filterZip,
            @RequestParam(name = "page", required = false) String page
    ){

        List<Order> orders = new ArrayList<>();

        Pageable pageable = null;
        try {
            int pageNum = Integer.parseInt(page);
            pageable = PageRequest.of(pageNum,2);
        }catch (Exception e){}

        if(filterZip == null) {
//            orderRepository.findAll().forEach(orders::add);
            orderRepository.findOrdersByUserOrderByPlacedAtDesc(user, pageable).get().forEach(orders::add);
        }else{
//            orderRepository.findOrdersByUserAndZipOrderByPlacedAtDesc(user, filterZip, pageable).forEach(orders::add);
            orderRepository.findOrdersByUserAndZipOrderByPlacedAtDesc(user, filterZip, pageable).get().forEach(orders::add);

        }

        model.addAttribute(orders);

        return "showOrders";
    }
}
