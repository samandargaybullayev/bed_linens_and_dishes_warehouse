package s1mpl3.coder.domain;

public class Dishes extends BaseDomain {
    private Integer material;
    private String weight;

    public Dishes(Long id, String name, String color, Double price, Integer amount, String manufactureDate,
                  Integer material, String weight) {
        super(id, name, color, price, amount, manufactureDate);
        this.material = material;
        this.weight = weight;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}