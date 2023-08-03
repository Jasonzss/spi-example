# SPI(Service Provider Interface)的简单实现

## 目录结构

spi-example:

├─service-provider：SPI接口的实现

├─service-provider-interface：SPI接口的定义

├─test：只导入service-provider包

└─test2：将service-provider包和service-provider-interface包都导入了

## 结论

resources/META-INF/services目录下以SPI接口全类名为文件名（例如：com.jason.example.spi.Logger）的文件里，记录了该SPI的实现类

java.util.ServiceLoader类可以将文件中记录的实现类全部加载出来。如果有多个文件中记录了多个实现类，那么这些实现类全都会被加载，具体使用哪个由SPI的调用方决定。
