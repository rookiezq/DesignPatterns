package com.rookied.dp.proxy.dynamicproxy;


import com.rookied.dp.proxy.staticproxy.Tank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangqiang
 * @date 2021/4/30
 */
public class TankProxy implements Moveable {

    @Override
    public void move() {
        System.out.println("moving...");
    }

    public static void main(String[] args) {
        TankProxy tank = new TankProxy();
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        Moveable move = (Moveable) Proxy.newProxyInstance(TankProxy.class.getClassLoader(),
                TankProxy.class.getInterfaces(), new TankLogProxy(tank));
        move.move();
    }
}

class TankLogProxy implements InvocationHandler {
    Object object;

    public TankLogProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start moving...");
        Object invoke = method.invoke(object, args);
        System.out.println("end moving...");
        return invoke;
    }
}

interface Moveable {
    void move();
}
