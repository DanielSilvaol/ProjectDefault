package br.edu.GEP.Infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface BaseController<T, S, A,D>
{
    @GetMapping
    List<T> Get();

    @PostMapping
    @Transactional
    ResponseEntity<T> Post(@RequestBody S command, UriComponentsBuilder builder);

    @PutMapping("/{id}")
    @Transactional
    ResponseEntity<T> Put(@PathVariable Long id, @RequestBody A command);

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity Delete(@RequestBody D command,@PathVariable Long id);
}
