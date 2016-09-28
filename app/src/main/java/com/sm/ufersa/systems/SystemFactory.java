package com.sm.ufersa.systems;

/**
 * Created by jdoneto on 26/09/2016.
 */

public class SystemFactory {

    public static SystemBase getInstance(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CMY")){
            return new CMY();
        } else if(shapeType.equalsIgnoreCase("XYZ")){
            return new XYZ();
        } else if( shapeType.equalsIgnoreCase("HSB") || shapeType.equalsIgnoreCase("HSI")
                || shapeType.equalsIgnoreCase("HSL") || shapeType.equalsIgnoreCase("HSV")){
            return new HS(shapeType);
        } else if(shapeType.equalsIgnoreCase("YCbCr")){
            return new YCbCr();
        } else if(shapeType.equalsIgnoreCase("YIQ")){
            return new YIQ();
        } else if(shapeType.equalsIgnoreCase("YUV")){
            return new YUV();
        }

        return null;
    }











}
