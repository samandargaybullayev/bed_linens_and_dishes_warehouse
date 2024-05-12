package s1mpl3.coder.domain;

public class BedLinens extends BaseDomain {
    private String material;
    private String weight;

    public BedLinens(Long id, String name, String color, Double price, Integer amount, String manufactureDate, String material, String weight) {
        super(id, name, color, price, amount, manufactureDate);
        this.material = material;
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}