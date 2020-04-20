package ru.knasys.springinactioon5.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knasys.springinactioon5.db.TacoRepository;
import ru.knasys.springinactioon5.entities.Taco;

import java.util.List;

@RepositoryRestController
public class RecentTacosController {
    private TacoRepository tacoRepository;

    public RecentTacosController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<List<Taco>> recentTacos(){
        PageRequest pageRequest  = PageRequest.of(0, 12, Sort.by("createAt").descending());
        List<Taco> tacos = tacoRepository.findAll(pageRequest).getContent();
        return new ResponseEntity<List<Taco>>(tacos, HttpStatus.OK);
    }
}
