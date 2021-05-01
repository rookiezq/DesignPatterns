package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public class Mgr06 {
    private Mgr06(){}

    private static class Mgr06Instance{
        private static final Mgr06 INSTANCE = new Mgr06();
    }

    public static Mgr06 getInstance(){
        return Mgr06Instance.INSTANCE;
    }

    //测试方法
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
