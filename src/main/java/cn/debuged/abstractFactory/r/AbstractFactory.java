package cn.debuged.abstractFactory.r;

public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory1 = new Factory1();

        ProductA productA = factory1.createProductA();
        productA.info();

        Factory factory2 = new Factory2();

        ProductB productB = factory2.createProductB();
        productB.info();
    }
}

interface Factory {
    public ProductA createProductA();
    public ProductB createProductB();
}

class Factory1 implements Factory {

    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}

class Factory2 implements Factory {

    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}

interface ProductA {
    public void info();
}

class ProductA1 implements ProductA {

    @Override
    public void info() {
        System.out.println("产品的信息：A1");
    }
}

class ProductA2 implements ProductA {

    @Override
    public void info() {
        System.out.println("产品的信息：A2");
    }
}

interface ProductB {
    public void info();
}

class ProductB1 implements ProductB {

    @Override
    public void info() {
        System.out.println("产品的信息：B1");
    }
}

class ProductB2 implements ProductB {

    @Override
    public void info() {
        System.out.println("产品的信息：B2");
    }
}