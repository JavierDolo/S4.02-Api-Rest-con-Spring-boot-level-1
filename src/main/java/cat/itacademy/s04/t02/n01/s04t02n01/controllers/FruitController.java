package cat.itacademy.s04.t02.n01.s04t02n01.controllers;

import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitRequest;
import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitResponse;
import cat.itacademy.s04.t02.n01.s04t02n01.service.FruitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fruits")
@Validated
@RequiredArgsConstructor
public class FruitController {

    private final FruitService service;

    @PostMapping
    public ResponseEntity<FruitResponse> createFruit(@Valid @RequestBody FruitRequest request) {
        FruitResponse created = service.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public ResponseEntity<List<FruitResponse>> getAllFruits() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FruitResponse> getFruitById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FruitResponse> updateFruit(@PathVariable @Positive Long id,
                                                     @Valid @RequestBody FruitRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable @Positive Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
