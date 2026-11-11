package com.example.adventurerguild.service;

import org.springframework.stereotype.Service;

import com.example.adventurerguild.model.Adventurer;
import com.example.adventurerguild.model.Guild;
import com.example.adventurerguild.model.Party;
import java.util.List;

@Service
public class GameService {
	
	private Guild guild = new Guild();
	private Party party = new Party();

	public List<Adventurer> getAdventurers() {
		return guild.getAdventurers();
	}
	public GameService(){
		guild.addAdventurer(new Adventurer(1, "アレン", 10));
		guild.addAdventurer(new Adventurer(2, "リナ", 8));
		guild.addAdventurer(new Adventurer(3, "ガルド", 12));
		guild.addAdventurer(new Adventurer(4, "アマンダ", 9));
	}
	
	public Party createParty(List<Integer> ids) {
		Party newParty = new Party();
		for (int id : ids){
			Adventurer adventurer = guild.findAdventurerById(id);
			if (adventurer == null) {
				throw new IllegalArgumentException("そんな冒険者は存在しません");
			}
			if (!newParty.getMembers().contains(adventurer)) {
				newParty.addMember(adventurer);
			}
		}
		this.party = newParty;
		return newParty;
		
	}
	
	public Party getParty() {
		return party;
	}
}
