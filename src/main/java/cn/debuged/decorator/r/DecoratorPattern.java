package cn.debuged.decorator.r;

public class DecoratorPattern {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        zhangsan = new DecoratorA(zhangsan);
        zhangsan = new DecoratorB(zhangsan);
        zhangsan.Operation();

        System.out.println("\n=====我是分割线=====");

        // 对象链
        Person lisi = new DecoratorB(new DecoratorA(new Student("李四")));
        lisi.Operation();
    }
}

abstract class Decorator extends Person {
    protected Person person;
}

class DecoratorA extends Decorator {
    public DecoratorA(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() { // 职责
        person.Operation(); // 原本的职责
        System.out.print("写作业 ");
    }
}

class DecoratorB extends Decorator {
    public DecoratorB(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() { // 职责
        person.Operation(); // 原本的职责
        System.out.print("考试 ");
    }
}

abstract class Person {
    protected String name;

    public abstract void Operation(); // 职责
}

class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.print(name + "的职责：学习 ");
    }
}