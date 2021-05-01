package com.rookied.dp.proxy.staticproxy;

import java.util.Random;

/**
 * @author zhangqiang
 * @date 2021/4/30
 */
public class Tank implements Move {

    @Override
    public void move() {
        System.out.println("moving...");
        try {
            Thread.sleep(new Random().nextInt(500)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Move move = new TankLog(new TankTime(new Tank()));
        move.move();
    }
}

interface Move {
    void move();
}

class TankTime implements Move {
    Move move;

    public TankTime(Move move) {
        this.move = move;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        move.move();
        System.out.println(System.currentTimeMillis() - start);
    }
}

class TankLog implements Move {
    Move move;

    public TankLog(Move move) {
        this.move = move;
    }

    @Override
    public void move() {
        System.out.println("Tank starts moving...");
        move.move();
        System.out.println("Tank stops moving...");
    }
}