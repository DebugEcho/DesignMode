package cn.debuged.bridgePattern.r;

public class BridgePattern {
    public static void main(String[] args) {
        Product productA1 = new ProductA();
        Product productA2 = new ProductA();
        Color red = new Red();

        productA1.setName("产品A1");
        productA1.setColor(red);
        productA1.Operation();


        Blue blue = new Blue();
        productA2.setName("产品A2");
        productA2.setColor(blue);
        productA2.Operation();
    }
}

abstract class Product {
    private String name;
    protected Color color;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}

class ProductA extends Product {

    @Override
    public void Operation() {
        color.OperationImp(this.getName());
    }
}

interface Color {
    public void OperationImp(String name);
}

class Red implements Color {

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "：红色");
    }
}

class Blue implements Color {

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "：蓝色");
    }
}