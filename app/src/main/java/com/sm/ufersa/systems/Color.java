package com.sm.ufersa.systems;

public class Color {

	private float component1;
	private float component2;
	private float component3;
	
	public Color(){
		component1 = 0;
		component2 = 0;
		component3 = 0;
	}

	public Color(float c1, float c2,float c3){
		component1 = c1;
		component2 = c2;
		component3 = c3;
	}
	
	public float getComponent1() {
		return component1;
	}
	public void setComponent1(float component1) {
		this.component1 = component1;
	}
	public float getComponent2() {
		return component2;
	}
	public void setComponent2(float component2) {
		this.component2 = component2;
	}
	public float getComponent3() {
		return component3;
	}
	public void setComponent3(float component3) {
		this.component3 = component3;
	}
}
