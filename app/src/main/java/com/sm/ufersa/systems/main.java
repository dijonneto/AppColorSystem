package com.sm.ufersa.systems;

public class main {
	
	public static void main (String args[]) {
		//Declaração de variáves de teste
		float r = 220;
		float g = 50;
		float b = 250;
		Color rgb = new Color();
		rgb.setComponent1(r);
		rgb.setComponent2(g);
		rgb.setComponent3(b);
		
		//Conversão RGB para HSV
		Color hsv = new Color();
		hsv = HS.setHsv(rgb);
		System.out.println("HSV - H: "+hsv.getComponent1()+" S: "+hsv.getComponent2()+" V: "+hsv.getComponent3());
		
		//Conversão RGB para HSB
		Color hsb = new Color();
		hsb = HS.setHsb(rgb);
		System.out.println("HSB - H: "+hsb.getComponent1()+" S: "+hsb.getComponent2()+" B: "+hsb.getComponent3());
		
		//Covnersão RGB para HSL
		Color hsl = new Color();
		hsl = HS.setHsl(rgb);
		System.out.println("HSL - H: "+hsl.getComponent1()+" S: "+hsl.getComponent2()+" L: "+hsl.getComponent3());
		
		//Covnersão RGB para HSI
		Color hsi = new Color();
		hsi = HS.setHsi(rgb);
		System.out.println("HSI - H: "+hsi.getComponent1()+" S: "+hsi.getComponent2()+" I: "+hsi.getComponent3());
	}

}
