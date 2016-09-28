package com.sm.ufersa.systems;

public class CMY implements SystemBase{

    @Override
    public Color convert(Color rgb){
        float r = rgb.getComponent1()/255;
        float g = rgb.getComponent2()/255;
        float b = rgb.getComponent3()/255;

        float k = 1 - Math.max(r, Math.max(g, b));

        float c, m, y;

        c = (1 - r - k) / (1 - k);
        m = (1 - g + k) / (1 - k);
        y = (1 - b + k) / (1 - k);

        return new Color(c*255, m*255, y*255);
    }

    @Override
    public String printResult(Color colorResult){
        return "C: "+ (int) colorResult.getComponent1() +
                "\nM: "+ (int) colorResult.getComponent2() +
                "\nY: " + (int) colorResult.getComponent3();
    }
}
