package com.rookied.dp.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/4/27
 */
public class StringFilter {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("qwert<script> helloworld996");

        String str = msg.getMsg();
        StrFilterChain fc1 = new StrFilterChain();
        fc1.add(new ScripFilter()).add(new SensitivFilter());
        fc1.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface StrFilter {
    boolean doFilter(Msg msg);
}

class ScripFilter implements StrFilter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replaceAll("<", "[");
        str = str.replaceAll(">", "]");
        msg.setMsg(str);
        return true;
    }
}

class SensitivFilter implements StrFilter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replaceAll("996", "955");
        msg.setMsg(str);
        return false;
    }
}

class StrFilterChain implements StrFilter {
    List<StrFilter> list = new ArrayList<>();

    StrFilterChain add(StrFilter filter) {
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (StrFilter filter : list) {
            if(!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
