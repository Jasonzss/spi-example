package com.jason.example.spi.service;

import com.jason.example.spi.Logger;

/**
 * @author Jason
 * @since 2023/08/03 - 22:08
 */
public class JasonLogger implements Logger {
    @Override
    public void info(String s) {
        System.out.println("JasonLog-Info:"+s);
    }

    @Override
    public void debug(String s) {
        System.out.println("JasonLog-Debug:"+s);
    }

    @Override
    public void warn(String s) {
        System.out.println("JasonLog-Warn:"+s);
    }

    @Override
    public void error(String s) {
        System.out.println("JasonLog-Error:"+s);
    }
}
