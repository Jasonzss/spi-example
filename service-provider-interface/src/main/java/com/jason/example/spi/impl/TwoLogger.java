package com.jason.example.spi.impl;

import com.jason.example.spi.Logger;

/**
 * @author Jason
 * @since 2023/08/03 - 23:20-
 */
public class TwoLogger implements Logger {
    @Override
    public void info(String msg) {
        System.out.println("two-info:"+msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("two-debug:"+msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("two-warn:"+msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("two-error:"+msg);
    }
}
