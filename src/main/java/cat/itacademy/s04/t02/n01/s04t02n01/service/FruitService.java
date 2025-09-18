package cat.itacademy.s04.t02.n01.s04t02n01.service;

import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitRequest;
import cat.itacademy.s04.t02.n01.s04t02n01.dto.FruitResponse;
import cat.itacademy.s04.t02.n01.s04t02n01.exception.ResourceNotFoundException;
import cat.itacademy.s04.t02.n01.s04t02n01.model.Fruit;
import cat.itacademy.s04.t02.n01.s04t02n01.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository repository;

    public FruitService(FruitRepository repository) {
        this.repository = repository;
    }

    // C-R-U-D
    public FruitResponse create(FruitRequest request) {
        Fruit fruit = new Fruit(request.getName(), request.getQuantityKilos());
        Fruit saved = repository.save(fruit);
        return new FruitResponse(saved.getId(), saved.getName(), saved.getQuantityKilos());
    }

    public FruitResponse getById(Integer id) {
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));
        return new FruitResponse(fruit.getId(), fruit.getName(), fruit.getQuantityKilos());
    }

    public List<FruitResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(fruit -> new FruitResponse(fruit.getId(), fruit.getName(), fruit.getQuantityKilos()))
                .toList();
    }

    public FruitResponse update(Integer id, FruitRequest request) {
        Fruit existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));

        existing.setName(request.getName());
        existing.setQuantityKilos(request.getQuantityKilos());
        Fruit updated = repository.save(existing);

        return new FruitResponse(updated.getId(), updated.getName(), updated.getQuantityKilos());
    }

    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Fruit not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
