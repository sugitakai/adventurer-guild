package com.example.adventurerguild.model;

public class Adventurer {
	
	private String name;
	private int power;

	public  Adventurer(String name, int power){
		this.name = name;
		this.power = power;
	}

	public String getName(){
		return name;
	}
	
	public int getPower() {
		return power;
	}
}
