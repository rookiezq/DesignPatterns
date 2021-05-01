package com.rookied.dp.factory.methodfactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class Client {
    public static void main(String[] args) {
        //使用何种工厂
        AbstractFactory af = new DELLKeyBoardFactory();

        //通知工厂制造键盘
        AbstractKeyBoard akb = af.creatKeyBoard();
        //使用键盘
        akb.print();
    }
}
