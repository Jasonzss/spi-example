# SPI(Service Provider Interface)的简单实现

## 目录结构

spi-example:

├─service-provider：SPI接口的实现

├─service-provider-interface：SPI接口的定义

├─test：只导入service-provider包

└─test2：将service-provider包和service-provider-interface包都导入了

## 结论

resources/META-INF/services目录下以SPI接口全类名为文件名（例如：com.jason.example.spi.Logger）的文件里，记录了该SPI的实现类

为什么是这个目录？因为约定俗成，看ServiceLoader的源码就知道了：![img](img.png)

java.util.ServiceLoader类可以将文件中记录的实现类全部加载出来。如果有多个文件中记录了多个实现类，那么这些实现类全都会被加载，具体使用哪个由SPI的调用方决定。

为什么需要SPI？个人看法：

1. **按需导入，方便管理**：接口的实现种类过多，放在一起不便管理，且大部分可能接口的调用者都用不上，所以将实现类拆开在不同的模块中，用户按需导入
2. **动态扩展的标准**：接口定制者没有办法将用户所有需要的实现类都实现出来，所以让用户自己去实现接口的实现或是导入自己需要的实现。JDBC接口就是如此，数据库这么多，JDBC的实现岂不是每一个数据库都得写一份？所以用户只需要导入JDBC接口和自己想使用的数据库驱动就可以了。
3. 想到了再加
