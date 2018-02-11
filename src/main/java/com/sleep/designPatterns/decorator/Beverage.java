package com.sleep.designPatterns.decorator;

import java.io.InputStream;

/** decorator装饰器模式抽象类
 * @author
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
