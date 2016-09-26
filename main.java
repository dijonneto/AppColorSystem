
public class main {
	
	public static void main (String args[]) {
		//Declaração de variáves de teste
		float r = 220;
		float g = 50;
		float b = 250;
		padrao rgb = new padrao();
		rgb.setComponente1(r);
		rgb.setComponente2(g);
		rgb.setComponente3(b);
		
		//Conversão RGB para HSV
		padrao hsv = new padrao();
		hsv = hs.setHsv(rgb);
		System.out.println("HSV - H: "+hsv.getComponente1()+" S: "+hsv.getComponente2()+" V: "+hsv.getComponente3());
		
		//Conversão RGB para HSB
		padrao hsb = new padrao();
		hsb = hs.setHsb(rgb);
		System.out.println("HSB - H: "+hsb.getComponente1()+" S: "+hsb.getComponente2()+" B: "+hsb.getComponente3());
		
		//Covnersão RGB para HSL
		padrao hsl = new padrao();
		hsl = hs.setHsl(rgb);
		System.out.println("HSL - H: "+hsl.getComponente1()+" S: "+hsl.getComponente2()+" L: "+hsl.getComponente3());
		
		//Covnersão RGB para HSI
		padrao hsi = new padrao();
		hsi = hs.setHsi(rgb);
		System.out.println("HSI - H: "+hsi.getComponente1()+" S: "+hsi.getComponente2()+" I: "+hsi.getComponente3());
	}

}
