package com.rookied.dp.factory.abstractfactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class HPFactory extends AbstractFactory {
    @Override
    AbstractKeyBoard creatKeyBoard() {
        System.out.println("惠普键盘制造完成");
        return new HPKeyboard();
    }

    @Override
    AbstractMouse creatMouse() {
        System.out.println("惠普鼠标制造完成");
        return new HPMouse();
    }
}
