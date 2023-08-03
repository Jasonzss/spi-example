package com.jason.example.spi.impl;

import com.jason.example.spi.Logger;

/**
 * @author Jason
 * @since 2023/08/03 - 23:20
 */
public class OneLogger implements Logger {
    @Override
    public void info(String msg) {
        System.out.println("one-info:"+msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("one-debug:"+msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("one-warn:"+msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("one-error:"+msg);
    }
}
