package com.sm.ufersa.systems;

public class YUV implements SystemBase{

	@Override
	public Color convert(Color rgb) {
		float r = rgb.getComponent1();
		float g = rgb.getComponent2();
		float b = rgb.getComponent3();

		float y = (float) (0.299 * r + 0.587 * g + 0.114 * b);
		float u = (float) (-0.14713 * r + -0.28886 * g + 0.436 * b);
		float v = (float) (0.615 * r + -0.51499 * g + -0.10001 * b);
	
		return new Color(y, u ,v);
	}

	@Override
	public String printResult(Color colorResult) {
		return "Y: "+ (int) colorResult.getComponent1() +
				"\nU: "+ (int) colorResult.getComponent2() +
				"\nV: " + (int) colorResult.getComponent3();
	}

}
