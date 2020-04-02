package ru.knasys.springinactioon5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* про lombok аннотации: https://easyjava.ru/java/lombok/generaciya-konstruktorov-i-dostup-k-polyam/ */

@Controller        /*Контроллер*/
public class HomeController {

    @GetMapping("/")      /*Обрабатывает запросы корневого пути */
    public String home(){
        return "home"; /*Возвращает имя представления*/
    }
}
