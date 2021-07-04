package com.github.fabriciolfj.multitenay.api;

import com.github.fabriciolfj.multitenay.domain.Person;
import com.github.fabriciolfj.multitenay.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody final Person person) {
        service.save(person);
    }

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

}
