package com.jason.example.spi;

/**
 * @author Jason
 * @since 2023/08/03 - 22:05
 */
public class Main {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();

        service.info("info SPI");
        service.debug("debug SPI");
        service.warn("warn SPI");
        service.error("error SPI");
    }
}