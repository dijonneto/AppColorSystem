package com.sm.ufersa.systems;

public class YCbCr implements SystemBase {
    @Override
    public Color convert(Color rgb) {
        float r = rgb.getComponent1();
        float g = rgb.getComponent2();
        float b = rgb.getComponent3();
        int Y = (int)(0.299*r+0.587*g+0.114*b);
        int Cb=(int)(128-0.169*r-0.331*g+0.500*b);
        int Cr =(int)(128+0.500*r-0.419*g-0.081*b);
        return new Color(Y, Cb, Cr);
    }

    @Override
    public String printResult(Color colorResult) {
        return "Y: "+ (int) colorResult.getComponent1() +
                "\nCb: "+ (int) colorResult.getComponent2() +
                "\nCr: " + (int) colorResult.getComponent3();
    }
}
