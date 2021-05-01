package com.rookied.dp.factory.abstractfactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class DELLFactory extends AbstractFactory {
    @Override
    AbstractKeyBoard creatKeyBoard() {
        System.out.println("戴尔键盘制造完成");
        return new DELLKeyboard();
    }

    @Override
    AbstractMouse creatMouse() {
        System.out.println("戴尔键盘制造完成");
        return new DELLMouse();
    }
}
