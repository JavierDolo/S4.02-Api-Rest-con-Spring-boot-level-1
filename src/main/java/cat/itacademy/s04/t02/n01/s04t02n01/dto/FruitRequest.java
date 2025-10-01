package cat.itacademy.s04.t02.n01.s04t02n01.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record FruitRequest(
        @NotBlank(message = "Name is required") String name,
        @Min(value = 1, message = "Quantity must be at least 1 Kg") int quantityKilos
) {}