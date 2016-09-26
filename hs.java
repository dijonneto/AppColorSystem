public class hs {
	
	//Processo comum para todos os padrões HS
	public static float[] hs(padrao rgb) {
		//R', G' e B'
		float r1, g1, b1;
		r1 = rgb.getComponente1()/255.0f;
		g1 = rgb.getComponente2()/255.0f;
		b1 = rgb.getComponente3()/255.0f;

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
	public static padrao setHsl (padrao rgb) {
		//Auxiliares
		float dados[], Cmax, Cmin, A, h, s, l;
		dados = hs(rgb);
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
		padrao hsl = new padrao();
		hsl.setComponente1((int)h);
		hsl.setComponente2(s*100);
		hsl.setComponente3(l*100);
		
		return hsl;
	}
	
	//Para o padrão HSV
	public static padrao setHsv (padrao rgb) {
		//Auxiliares
		float dados[], Cmax, A, h, s, v;
		dados = hs(rgb);
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
		padrao hsv = new padrao();
		hsv.setComponente1((int)h);
		hsv.setComponente2(s*100);
		hsv.setComponente3(v*100);
		return hsv;
	}
	
	//Para o padrão HSI
	public static padrao setHsi (padrao rgb) {
		//Auxiliares
		float dados[], Cmin, h, s, i;
		dados = hs(rgb);
		Cmin = dados[1];
		h = dados[3];
		
		//Value
		i = (rgb.getComponente1() + rgb.getComponente2() + rgb.getComponente3()) / 3;

		//Intensity
		if (i > 0) {
			s = 1 - (Cmin*255)/i;
		}
		else {
			s = 0;
		}
		
		//Retorno da função de conversão
		padrao hsv = new padrao();
		hsv.setComponente1((int)h);
		hsv.setComponente2(s*100);
		hsv.setComponente3(i);
		return hsv;
	}
	
	//Para o padrão HSB
	public static padrao setHsb (padrao rgb) {
		//Auxiliares
		float dados[], Cmax, Cmin, A, h, s, b;
		dados = hs(rgb);
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
		padrao hsv = new padrao();
		hsv.setComponente1((int)h);
		hsv.setComponente2(s*100);
		hsv.setComponente3(b*100);
		return hsv;
	}
}