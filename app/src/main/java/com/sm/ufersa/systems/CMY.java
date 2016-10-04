package com.sm.ufersa.systems;

public class CMY implements SystemBase{

    @Override
    public Color convert(Color rgb){
        float r = rgb.getComponent1()/255;
        float g = rgb.getComponent2()/255;
        float b = rgb.getComponent3()/255;

//        float k = 1 - Math.max(r, Math.max(g, b));

        float c, m, y;

        c = 1 - ( r / 255 );
        m = 1 - ( g / 255 );
        y = 1 - ( b / 255 );

//        c = (1 - r - k) / (1 - k);
//        m = (1 - g + k) / (1 - k);
//        y = (1 - b + k) / (1 - k);
//
//        c = Math.min(c*255, 255);
//        m = Math.min(m*255, 255);
//        y = Math.min(y*255, 255);

        return new Color(c, m, y);
    }

    @Override
    public String printResult(Color colorResult){
        return "C: "+ colorResult.getComponent1() +
                "\nM: "+ colorResult.getComponent2() +
                "\nY: " + colorResult.getComponent3();
    }
}
