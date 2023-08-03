package com.jason.example.spi;

/**
 * @author Jason
 * @since 2023/08/03 - 22:00
 */
public interface Logger {
    void info(String msg);

    void debug(String msg);

    void warn(String msg);

    void error(String msg);
}
