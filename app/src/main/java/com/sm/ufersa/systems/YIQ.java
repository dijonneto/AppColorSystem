package com.sm.ufersa.systems;

public class YIQ implements SystemBase {
    @Override
    public Color convert(Color rgb) {
        float r = rgb.getComponent1();
        float g = rgb.getComponent2();
        float b = rgb.getComponent3();
        int Y = (int)(0.299*r+0.587*g+0.114*b);
        int I=(int)(0.596*r-0.275*g+0.321*b);
        int Q =(int)(0.212*r-0.523*g-0.311*b);
        return new Color(Y, I, Q);
    }

    @Override
    public String printResult(Color colorResult) {
        return "Y: "+ (int) colorResult.getComponent1() +
                "\nI: "+ (int) colorResult.getComponent2() +
                "\nQ: " + (int) colorResult.getComponent3();
    }
}
