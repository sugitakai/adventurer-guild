package com.example.adventurerguild.model;

public class Adventurer {
	
	private int id;
	private String name;
	private int power;

	public  Adventurer(int id, String name, int power){
		this.id = id;
		this.name = name;
		this.power = power;
	}

	public int getId() {
		return id;
	}

	public String getName(){
		return name;
	}
	
	public int getPower() {
		return power;
	}
}
