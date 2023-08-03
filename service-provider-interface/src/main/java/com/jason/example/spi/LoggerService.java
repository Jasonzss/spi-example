package com.jason.example.spi;

import com.jason.example.spi.impl.OneLogger;
import com.jason.example.spi.impl.TwoLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Jason
 * @since 2023/08/03 - 22:00
 */
public class LoggerService {
    private static final LoggerService SERVICE = new LoggerService();

    private final Logger logger;

    /** 查询到的所有实现类 **/
    private final List<Logger> loggerList;

    private LoggerService() {
        ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);
        List<Logger> list = new ArrayList<>();
        for (Logger log : loader) {
            list.add(log);
        }
        System.out.println("扫描到的Logger实现个数："+list.size());
        // LoggerList 是所有 ServiceProvider
        loggerList = list;
        if (!list.isEmpty()) {
            // Logger 只取一个
            logger = list.get(0);
        } else {
            logger = null;
        }
    }

    public static LoggerService getService() {
        return SERVICE;
    }

    //-------------为了方便用户使用，将多个服务的选择逻辑封装在这里------------

    /**
     * 只使用其中之一执行该方法
     */
    public void info(String msg) {
        if (logger == null) {
            System.out.println("info 中没有发现 Logger 服务提供者");
        } else {
            logger.info(msg);
        }
    }

    /**
     * 遍历所有的实现类，挨个执行一次
     */
    public void debug(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("debug 中没有发现 Logger 服务提供者");
        }
        loggerList.forEach(log -> log.debug(msg));
    }

    /**
     * 选择指定类型的实现类执行
     */
    public void warn(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("warn 中没有发现 Logger 服务提供者");
        }
        loggerList.forEach(log -> {
            if (log.getClass().isAssignableFrom(OneLogger.class)){
                log.warn(msg);
            }
        });
    }

    /**
     * 排除自带的实现类，查看是否存在其他实现类
     */
    public void error(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("error 中没有发现 Logger 服务提供者");
        }
        boolean flag = false;
        for (Logger log : loggerList) {
            if (!log.getClass().isAssignableFrom(TwoLogger.class) &&
                    !log.getClass().isAssignableFrom(OneLogger.class)) {
                flag = true;
            }
        }

        if (flag) {
            logger.error(msg);
        }else {
            System.out.println("error 中没有发现 Logger 其他服务提供者");
        }
    }
}
