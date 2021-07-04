package com.github.fabriciolfj.multitenay.repository;

import com.github.fabriciolfj.multitenay.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
