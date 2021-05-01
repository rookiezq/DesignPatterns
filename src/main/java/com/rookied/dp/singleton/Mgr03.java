package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public class Mgr03 {
    private static Mgr03 INSTANCE = null;

    private Mgr03(){}

    public static synchronized Mgr03 getInstance(){
        if(INSTANCE == null){
            //测试，使更多线程进入判断
            try {
                Thread.sleep(1); //try-catch
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    //测试方法
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
