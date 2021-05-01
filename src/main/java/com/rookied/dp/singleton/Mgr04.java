package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public class Mgr04 {
    private static Mgr04 INSTANCE = null;

    private Mgr04(){}

    public static Mgr04 getInstance(){
        if(INSTANCE == null){
            synchronized(Mgr04.class){
                //测试，使更多线程进入判断
                try {
                    Thread.sleep(1); //try-catch
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }

    //测试方法
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
