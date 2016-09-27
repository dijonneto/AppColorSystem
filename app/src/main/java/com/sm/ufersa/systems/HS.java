package com.sm.ufersa.systems;

public class HS implements SystemBase{

	private String system;

	public HS(String s){
		this.system = s;
	}

	@Override
	public Color convert(Color rgb){
		if (system.contains("B")){
			return setHsb(rgb);
		} else if (system.contains("I")){
			return setHsi(rgb);
		} else if (system.contains("L")){
			return setHsl(rgb);
		} else if (system.contains("V")){
			return setHsv(rgb);
		} else {
			return null;
		}
	}

	@Override
	public String printResult(Color colorResult){
		String result = "H: "+ (int) colorResult.getComponent1() +
						"\nS: "+ (int) colorResult.getComponent2() + "\n";
		if (system.contains("B")){
			result += "B: ";
		} else if (system.contains("I")){
			result += "I: ";
		} else if (system.contains("L")){
			result += "L: ";
		} else if (system.contains("V")){
			result += "V: ";
		} else {
			result = null;
		}
		if(result != null)
			result += (int) colorResult.getComponent3();

		return result;
	}
	
	//Processo comum para todos os padrões HS
	public static float[] commonProcess(Color rgb) {
		//R', G' e B'
		float r1, g1, b1;
		r1 = rgb.getComponent1()/255.0f;
		g1 = rgb.getComponent2()/255.0f;
		b1 = rgb.getComponent3()/255.0f;

		//C máximo e mínimo
		float Cmax = 0;
		Cmax = Math.max(Math.max(r1, g1),b1);
		float Cmin = 0;
		Cmin = Math.min(Math.min(r1, g1),b1);
		
		//Delta
		float A = Cmax - Cmin;
		
		//Hue
		float h = 0;
		if (A == 0) {
			h = 0;
		}				   
		else if (Cmax == r1) {
			h = 60.0f*(((g1-b1)/A)%6);
		}
		else if (Cmax == g1) {
			h = 60.0f*(((b1-r1)/A)+2);
		}
		else if (Cmax == b1) {
			h = 60.0f*(((r1-g1)/A)+4);
		}
		float dados[];
		dados = new float[4];
		dados[0] = Cmax;
		dados[1] = Cmin;
		dados[2] = A;
		dados[3] = h;
		return dados;
	}
	
	//Para o padrão HSL
	public static Color setHsl (Color rgb) {
		//Auxiliares
		float dados[], Cmax, Cmin, A, h, s, l;
		dados = commonProcess(rgb);
		Cmax = dados[0];
		Cmin = dados[1];
		A = dados[2];
		h = dados[3];
		
		//Lightness
		l = (Cmax + Cmin)/2.0F;
		
		//Saturation
		if (A == 0) {
			s = 0;
		}
		else {
			float l1 = 2*l-1;
			if (l1 < 0) {
				l1 = -1*l1;
			}
			s = (A/(1-l1));
		}
		//Retorno da função de conversão
		Color hsl = new Color();
		hsl.setComponent1((int)h);
		hsl.setComponent2(s*100);
		hsl.setComponent3(l*100);
		
		return hsl;
	}
	
	//Para o padrão HSV
	public static Color setHsv (Color rgb) {
		//Auxiliares
		float dados[], Cmax, A, h, s, v;
		dados = commonProcess(rgb);
		Cmax = dados[0];
		A = dados[2];
		h = dados[3];
		
		//Value
		v = Cmax;
		
		//Saturation
		if (Cmax == 0) {
			s = 0;
		}
		else {
			s = A/Cmax;
		}
		
		//Retorno da função de conversão
		Color hsv = new Color();
		hsv.setComponent1((int)h);
		hsv.setComponent2(s*100);
		hsv.setComponent3(v*100);
		return hsv;
	}
	
	//Para o padrão HSI
	public static Color setHsi (Color rgb) {
		//Auxiliares
		float dados[], Cmin, h, s, i;
		dados = commonProcess(rgb);
		Cmin = dados[1];
		h = dados[3];
		
		//Value
		i = (rgb.getComponent1() + rgb.getComponent2() + rgb.getComponent3()) / 3;

		//Intensity
		if (i > 0) {
			s = 1 - (Cmin*255)/i;
		}
		else {
			s = 0;
		}
		
		//Retorno da função de conversão
		Color hsv = new Color();
		hsv.setComponent1((int)h);
		hsv.setComponent2(s*100);
		hsv.setComponent3(i);
		return hsv;
	}
	
	//Para o padrão HSB
	public static Color setHsb (Color rgb) {
		//Auxiliares
		float dados[], Cmax, Cmin, A, h, s, b;
		dados = commonProcess(rgb);
		Cmax = dados[0];
		Cmin = dados[1];
		A = dados[2];
		h = dados[3];
				
		//Bright
		b = Cmax;

		//Saturation
		if (Cmax == 0) {
			s = 0;
		}
		else {
			s = A/Cmax;
		}
		
		//Retorno da função de conversão
		Color hsv = new Color();
		hsv.setComponent1((int)h);
		hsv.setComponent2(s*100);
		hsv.setComponent3(b*100);
		return hsv;
	}
}