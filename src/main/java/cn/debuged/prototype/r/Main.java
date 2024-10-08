package cn.debuged.prototype.r;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(2022, 5.28);
        System.out.println(product1.getId() + " " + product1.getPrice());

        // Product product2 = new Product(2022, 5.28);
        Product product2 = (Product) product1.Clone();
        System.out.println(product2.getId() + " " + product2.getPrice());

        Product product3 = (Product) product1.Clone();
        System.out.println(product3.getId() + " " + product3.getPrice());
    }
}

interface Prototype {
    Object Clone();
}

class Product implements Prototype {
    private int id;
    private double price;

    public Product() {}

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object Clone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;

        return object;
    }
}