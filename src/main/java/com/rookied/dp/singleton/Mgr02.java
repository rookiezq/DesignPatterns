package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public class Mgr02 {
    private static Mgr02 INSTANCE = null;

    private Mgr02(){}

    public static Mgr02 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr02.getInstance().hashCode())).start();
        }
    }
}
