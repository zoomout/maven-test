package com.bogdan.web.strategy;

/**
 * Created by zoomout on 4/29/16.
 */
public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
