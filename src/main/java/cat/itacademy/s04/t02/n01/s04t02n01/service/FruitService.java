package cat.itacademy.s04.t02.n01.s04t02n01.service;

import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitRequest;
import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitResponse;
import cat.itacademy.s04.t02.n01.s04t02n01.model.Fruit;
import cat.itacademy.s04.t02.n01.s04t02n01.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cat.itacademy.s04.t02.n01.s04t02n01.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FruitService {

    private final FruitRepository repository;

    @Transactional(readOnly = true)
    public List<FruitResponse> getAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public FruitResponse getById(Long id) {
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));
        return toResponse(fruit);
    }

    public FruitResponse create(FruitRequest request) {
        Fruit fruit = new Fruit(request.name(), request.quantityKilos());
        return toResponse(repository.save(fruit));
    }

    public FruitResponse update(Long id, FruitRequest request) {
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));

        fruit.setName(request.name());
        fruit.setQuantityKilos(request.quantityKilos());

        return toResponse(repository.save(fruit));
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Fruit not found with id: " + id);
        }
    }

    private FruitResponse toResponse(Fruit fruit) {
        return new FruitResponse(fruit.getId(), fruit.getName(), fruit.getQuantityKilos());
    }
}
