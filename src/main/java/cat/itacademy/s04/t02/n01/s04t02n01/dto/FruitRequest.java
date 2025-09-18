package cat.itacademy.s04.t02.n01.s04t02n01.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class FruitRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Quantity must be at least 1 Kg")
    private int quantityKilos;

    public FruitRequest() {}

    public FruitRequest(String name, int quantityKilos) {
        this.name = name;
        this.quantityKilos = quantityKilos;
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
