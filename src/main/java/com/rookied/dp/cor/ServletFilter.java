package com.rookied.dp.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/4/27
 */
public class ServletFilter {
    public static void main(String[] args) {
        Request request = new Request();
        request.msg = "";
        Respence respence = new Respence();
        respence.msg = "";
        FilterChain fc = new FilterChain();
        fc.add(new ScriptFilter()).add(new SensitiveFilter());
        fc.doFilter(request,respence,fc);
        System.out.println(request.msg);
        System.out.println(respence.msg);
    }
}

class Request {
    String msg;
}

class Respence {
    String msg;
}

interface Filter {
    boolean doFilter(Request request, Respence respence, FilterChain filterChain);
}

class ScriptFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Respence respence, FilterChain filterChain) {

        if(request != null){
            request.msg += "1";
            return true;
        }else{
            respence.msg += "1";
            return true;
        }
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Respence respence, FilterChain filterChain) {
        if(request != null){
            request.msg += "2";
            return true;
        }else{
            respence.msg += "2";
            return true;
        }
    }
}

class FilterChain implements Filter {
    List<Filter> list = new ArrayList<>();

    FilterChain add(Filter filter) {
        list.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Respence respence, FilterChain filterChain) {
        for (int i=0;i<list.size();i++) {
            if (!list.get(i).doFilter(request,null,filterChain)) {
                return false;
            }
        }
        for (int i=list.size()-1;i>=0;i--) {
            if (!list.get(i).doFilter(null,respence,filterChain)) {
                return false;
            }
        }
        return true;
    }
}

