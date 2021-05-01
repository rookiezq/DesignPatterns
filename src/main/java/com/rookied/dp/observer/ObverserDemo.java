package com.rookied.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/4/29
 */
public class ObverserDemo {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    List<Observer> list = new ArrayList<>();

    public Child() {
        list.add(new Dad());
        list.add(new Mum());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        WakeEvent event = new WakeEvent(System.currentTimeMillis(), "bed", this);
        for (Observer observer : list) {
            observer.action(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class WakeEvent extends Event<Child> {
    long time;
    String loc;
    Child source;

    public WakeEvent(long time, String loc, Child source) {
        this.time = time;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return null;
    }
}

interface Observer {
    void action(WakeEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("Dad feed");
    }

    @Override
    public void action(WakeEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("Mum hug");
    }

    @Override
    public void action(WakeEvent event) {
        hug();
    }
}
