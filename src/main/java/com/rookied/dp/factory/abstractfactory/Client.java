package com.rookied.dp.factory.abstractfactory;

import com.rookied.dp.factory.methodfactory.DELLKeyBoardFactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class Client {
    public static void main(String[] args) {
        /*----拓展工厂时只需要知道使用哪种具体工厂----*/
        AbstractFactory af = new DELLFactory();

        /*--------下面的代码无需更改---------*/
        AbstractKeyBoard akb = af.creatKeyBoard();
        akb.print();
        AbstractMouse am = af.creatMouse();
        am.move();
    }
}
