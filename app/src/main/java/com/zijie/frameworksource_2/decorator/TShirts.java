package com.zijie.frameworksource_2.decorator;

public class TShirts extends Decorator{

	public TShirts(Person finery) {
		super(finery);
		// TODO Auto-generated constructor stub
	}
	
	public void show(){
		super.show();
		System.out.print(" 展示T恤 Tshirts");
	}

}
