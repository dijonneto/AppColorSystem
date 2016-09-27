package multimidia;

public class XYZ implements SystemBase{

	
	@Override
	public Color convert(Color rgb) {
		// TODO Auto-generated method stub
		
		float r = rgb.getComponent1();
		float g = rgb.getComponent2();
		float b = rgb.getComponent3();

		float auxR = r / 255;
		float auxG = g / 255;
		float auxB = b / 255;
		
		if(auxR > 0.04045){
			auxR = (float) Math.pow(((auxR + 0.055) / 1.055), 2.4);
			auxG = (float) Math.pow(((auxG + 0.055) / 1.055), 2.4);
			auxB = (float) Math.pow(((auxB + 0.055) / 1.055), 2.4);
		}

		auxR *= 100;
		auxG *= 100;
		auxB *= 100;
		
		System.out.println();

		float x = (float) (auxR * 0.4124 + auxG * 0.3576 + auxB * 0.1805);
		float y = (float) (auxR * 0.2126 + auxG * 0.7152 + auxB * 0.0722);
		float z = (float) (auxR * 0.0193 + auxG * 0.1192 + auxB * 0.9505);
		
		return new Color(x, y, z);
	}

	
}
