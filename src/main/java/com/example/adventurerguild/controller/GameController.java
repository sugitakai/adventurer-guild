
package com.example.adventurerguild.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adventurerguild.model.Adventurer;
import com.example.adventurerguild.model.Party;

import java.util.Map;

@RestController
public class GameController {

	private Party party = new Party();

	public GameController(){
		party.addMember(new Adventurer("アレン", 10));
		party.addMember(new Adventurer("リナ",8));
		party.addMember(new Adventurer("ガルド", 12));
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

}
