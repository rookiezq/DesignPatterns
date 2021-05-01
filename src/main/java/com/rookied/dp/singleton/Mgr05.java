package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public class Mgr05 {
    private static volatile Mgr05 INSTANCE = null;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        if(INSTANCE == null){
            synchronized(Mgr05.class){
                if(INSTANCE == null){
                    //测试，使更多线程进入判断
                    try {
                        Thread.sleep(1); //try-catch
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }

    //测试方法
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }
}
