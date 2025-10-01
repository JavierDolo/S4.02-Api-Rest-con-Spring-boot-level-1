package cat.itacademy.s04.t02.n01.s04t02n01.repository;

import cat.itacademy.s04.t02.n01.s04t02n01.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {}