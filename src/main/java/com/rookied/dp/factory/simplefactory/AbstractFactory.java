package com.rookied.dp.factory.simplefactory;

/**
 * @author zhangqiang
 * @date 2021/4/26
 */
public class AbstractFactory {
    public AbstractKeyBoard creatKeyBoard(String brand){
        if("HP".equals(brand)){
            return new HPKeyboard();
        }else if("DELL".equals(brand)){
            return new DELLKeyboard();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractFactory af = new AbstractFactory();

        AbstractKeyBoard hp = af.creatKeyBoard("HP");
        hp.print();
    }
}
