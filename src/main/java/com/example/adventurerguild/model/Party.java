package com.example.adventurerguild.model;

import java.util.ArrayList;
import java.util.List;

public class Party {

	private List<Adventurer> members = new ArrayList<>();
	public void addMember(Adventurer adventurer){
		members.add(adventurer);
	}

	public List<Adventurer> getMembers(){
		return members;
	}

	public int getTotalPower(){
		int total = 0;

		for(Adventurer adventurer:members){
			total += adventurer.getPower();
		}

		return total;
	}


	
}