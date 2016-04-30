package com.bogdan.project.strategy;

/**
 * Created by zoomout on 4/29/16.
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
