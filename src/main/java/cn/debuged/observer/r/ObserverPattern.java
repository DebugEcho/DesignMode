package cn.debuged.observer.r;

import java.util.*;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subjectA = new ConcreteSubject("目标A");

        Observer observerB = new ConcreteObserver("张三", subjectA);
        Observer observerC = new ConcreteObserver("李四", subjectA);
        Observer observerD = new ConcreteObserver("王五", subjectA);

        subjectA.setState("更新了");

        System.out.println("======================================");

        subjectA.Detach(observerD);

        subjectA.setState("停更了");
    }
}

interface Subject { // 目标
    void Attach(Observer observer); // 添加观察者
    void Detach(Observer observer); // 删除观察者
    void Notify(); // 状态改变后 通知所有观察者

    void setState(String state); // 设置状态（改变状态）
    String getState(); // 获取状态
}

class ConcreteSubject implements Subject {
    private final String name;
    private String state;

    private final List<Observer> observerList;

    public ConcreteSubject(String name) {
        state = "未更新";
        this.name = name;

        observerList = new ArrayList<Observer>();
    }

    public void setState(String state) {
        this.state = state;

        System.out.println(name + "的状态发生变化，变化后的状态为：" + state);
        Notify();
    }

    public String getState() {
        return state;
    }

    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    public void Notify() {
        // for (遍历对象类型 对象名 : 遍历对象)
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}

interface Observer { // 观察者接口
    void update(); // 收到通知 更新观察者的状态
}

class ConcreteObserver implements Observer {
    private final String name;
    private String state;

    private final Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;

        this.subject = subject;
        subject.Attach(this);

        state = subject.getState();
    }

    @Override
    public void update() {
        System.out.println(name + "收到通知");
        state = subject.getState(); // 让当前观察者的状态 和 改变了状态之后的目标的状态保持一致

        System.out.println(name + "改变后的状态为：" + state);
    }
}