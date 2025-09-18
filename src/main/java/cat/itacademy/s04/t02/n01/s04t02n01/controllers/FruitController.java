package cat.itacademy.s04.t02.n01.s04t02n01.controllers;


import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitRequest;
import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitResponse;
import cat.itacademy.s04.t02.n01.s04t02n01.service.FruitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")

public class FruitController {
    private final FruitService service;

    public FruitController(FruitService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<FruitResponse> createFruit(@Valid @RequestBody FruitRequest request) {
        FruitResponse created = service.create(request);
        return ResponseEntity.ok(created);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<FruitResponse>> getAllFruits() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FruitResponse> getFruitById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<FruitResponse> updateFruit(@PathVariable Integer id,
                                                     @Valid @RequestBody FruitRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
