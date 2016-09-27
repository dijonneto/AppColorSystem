package multimidia;

public class YUV implements SystemBase{

	@Override
	public Color convert(Color rgb) {
		
		float y;
		float u;
		float v;
		
		float r = rgb.getComponent1();
		float g = rgb.getComponent2();
		float b = rgb.getComponent3();
		
		y = (float) (0.299 * r + 0.587 * g + 0.114 * b);
		u = (float) (-0.14713 * r + -0.28886 * g + 0.436 * b);
		v = (float) (0.615 * r + -0.51499 * g + -0.10001 * b);
	
		return new Color(y, u ,v);
	}

}
