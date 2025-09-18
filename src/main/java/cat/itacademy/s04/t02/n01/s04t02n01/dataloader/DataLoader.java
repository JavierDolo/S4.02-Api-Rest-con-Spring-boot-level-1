package cat.itacademy.s04.t02.n01.s04t02n01.dataloader;

import cat.itacademy.s04.t02.n01.s04t02n01.model.Fruit;
import cat.itacademy.s04.t02.n01.s04t02n01.repository.FruitRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final FruitRepository fruitRepository;

    public DataLoader(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @PostConstruct
    public void initData() {
        fruitRepository.save(new Fruit("Apple", 10));
        fruitRepository.save(new Fruit("Orange", 15));
        System.out.println("Datos de prueba insertados en la base de datos.");
    }
}