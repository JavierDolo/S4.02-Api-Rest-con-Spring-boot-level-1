package cat.itacademy.s04.t02.n01.s04t02n01.dataloader;

import cat.itacademy.s04.t02.n01.s04t02n01.model.Fruit;
import cat.itacademy.s04.t02.n01.s04t02n01.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final FruitRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Fruit("Manzana", 10));
            repository.save(new Fruit("Pera", 5));
            repository.save(new Fruit("Plátano", 20));
        }
    }
}
