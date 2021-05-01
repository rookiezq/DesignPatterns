package com.rookied.dp.singleton;

/**
 * @author zhangqiang
 * @date 2021/4/25
 */
public enum  Mgr07 {
    //单例
    INSTANCE;

    public static Mgr07 getInstance(){
        return INSTANCE;
    }

    //测试方法
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr07.getInstance().hashCode())).start();
        }
    }
}
