package cat.itacademy.s04.t02.n01.s04t02n01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cantidadKilos;

    // Constructors
    public Fruit() {}
    public Fruit(String name, int cantidadKilos) {
        this.name = name;
        this.cantidadKilos = cantidadKilos;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCantidadKilos() {
        return cantidadKilos;
    }
    public void setCantidadKilos(int cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }
}
