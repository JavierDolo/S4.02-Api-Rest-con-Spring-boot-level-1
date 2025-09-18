package cat.itacademy.s04.t02.n01.s04t02n01.dto;

public class FruitResponse {

    private Integer id;
    private String name;
    private int quantityKilos;

    public FruitResponse(Integer id, String name, int quantityKilos) {
        this.id = id;
        this.name = name;
        this.quantityKilos = quantityKilos;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantityKilos() {
        return quantityKilos;
    }
}
