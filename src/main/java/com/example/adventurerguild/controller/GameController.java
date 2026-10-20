
package com.example.adventurerguild.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.adventurerguild.model.Adventurer;
import com.example.adventurerguild.model.Party;
import com.example.adventurerguild.model.Guild;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class GameController {

	private Guild guild = new Guild();
	private Party party = new Party();

	public GameController(){
		guild.addAdventurer(new Adventurer(1, "アレン", 10));
		guild.addAdventurer(new Adventurer(2, "リナ",8));
		guild.addAdventurer(new Adventurer(3, "ガルド", 12));
		guild.addAdventurer(new Adventurer(4, "アマンダ", 9));
	}

	@GetMapping("/api/adventurers")
	public List<Adventurer> getAdventurers() {
		return guild.getAdventurers();
	}
	

	@GetMapping("/api/game")
	public Map<String, Object> getGameStatus() {
		return Map.of(
				"gameName", "冒険者ギルド運営シミュレーター",
				"day", 1,
				"gold", 500,
				"members", party.getMembers(),
				"totalPower", party.getTotalPower(),
				"message", "ギルド運営を開始できます！"
			);
	}

	@PostMapping("/api/party")
	public Map<String, Object> createParty(@RequestBody List<Integer> ids) {
		
		Party newParty = new Party();
		
		for(int id : ids){
			Adventurer adventurer = guild.findAdventurerById(id);

			if (adventurer == null) {
				throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"冒険者ID" + id + "は存在しません"
				);
			}
			if (newParty.getMembers().contains(adventurer)) {
				throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"同じ冒険者を重視して編成できません"
				);
			}
			newParty.addMember(adventurer);
		}

		this.party = newParty;

		return Map.of(
			"members", party.getMembers(),
			"totalPower", party.getTotalPower()
		);
	}
	
}
