package com.github.fabriciolfj.multitenay.service;

import com.github.fabriciolfj.multitenay.domain.Person;
import com.github.fabriciolfj.multitenay.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void save(final Person person) {
        personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
