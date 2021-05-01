package com.rookied.dp.factory.methodfactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class HPKeyBoardFactory extends AbstractFactory {
    @Override
    AbstractKeyBoard creatKeyBoard() {
        System.out.println("惠普键盘制造完成");
        return new HPKeyboard();
    }
}
