package com.example.adventurerguild.model;

import java.util.ArrayList;
import java.util.List;


public class Guild {
	
	private List<Adventurer> adventurers = new ArrayList<>();

	public Adventurer findAdventurerById(int id){
		for(Adventurer adventurer : adventurers){
			if (adventurer.getId() == id) {
				return adventurer;
			}
		}
		return null;
	}

	public void addAdventurer(Adventurer adventurer){
		adventurers.add(adventurer);
	}

	public List<Adventurer> getAdventurers(){
		return adventurers;
	}
}
