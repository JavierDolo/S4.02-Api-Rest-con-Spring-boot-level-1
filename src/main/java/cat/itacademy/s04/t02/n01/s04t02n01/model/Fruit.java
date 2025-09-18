package cat.itacademy.s04.t02.n01.s04t02n01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantityKilos;

    // Constructors
    public Fruit() {}

    public Fruit(String name, int quantityKilos) {
        this.name = name;
        this.quantityKilos = quantityKilos;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilos() {
        return quantityKilos;
    }
    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }
}
