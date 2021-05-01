package com.rookied.dp.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author zhangqiang
 * @date 2021/4/30
 */
public class TankCglib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TankLog());
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TankLog implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("当前类是:" + o.getClass().getName() + ", 父类是:" + o.getClass().getSuperclass().getName());

        System.out.println("start moving...");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("end moving...");
        return invoke;
    }
}

class Tank {
    public void move() {
        System.out.println("moving...");
        try {
            Thread.sleep(new Random().nextInt(500) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
