package com.spring.mongo.demo.controller;


import com.spring.mongo.demo.model.SuperHero;
import com.spring.mongo.demo.service.SuperHeroService;
import com.spring.mongo.demo.utils.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/super-hero")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping
    public ResponseEntity<PagedResponse<?>> findAll(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        List<?> list = superHeroService.findAll();
        long total = list.size();

        List<?> paginatedList = paginateList(list, pageIndex, pageSize);

        PagedResponse<?> response = new PagedResponse<>();
        response.setData(paginatedList);
        response.setPageIndex(pageIndex);
        response.setPageSize(pageSize);
        response.setTotal(total);

        return ResponseEntity.ok().body(response);
    }

    private List<?> paginateList(List<?> list, int pageIndex, int pageSize) {
        int startIndex = (pageIndex - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        return list.subList(startIndex, endIndex);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        SuperHero superHero = superHeroService.findById(id);
        return ResponseEntity.ok().body(superHero);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {
        SuperHero savedSuperHero = superHeroService.save(superHero);
        return ResponseEntity.ok().body(savedSuperHero);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        superHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
