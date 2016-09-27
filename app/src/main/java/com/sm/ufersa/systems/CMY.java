package com.sm.ufersa.systems;

public class CMY implements SystemBase{

    @Override
    public Color convert(Color rgb){
        float c = 1 - rgb.getComponent1();
        float m = 1 - rgb.getComponent2();
        float y = 1 - rgb.getComponent3();

        return new Color(c, m, y);
    }

    @Override
    public String printResult(Color colorResult){
        return "C: "+ (int) colorResult.getComponent1() +
                "\nM: "+ (int) colorResult.getComponent2() +
                "\nY: " + (int) colorResult.getComponent3();
    }
}
