package s1mpl3.coder.domain;

public abstract class BaseDomain {
    protected Long id;
    protected String name;
    protected String color;
    protected Double price;
    protected Integer amount;
    protected String manufactureDate;

    public BaseDomain(Long id, String name, String color, Double price, Integer amount, String manufactureDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.amount = amount;
        this.manufactureDate = manufactureDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
