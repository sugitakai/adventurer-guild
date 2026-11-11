
package com.example.adventurerguild.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.adventurerguild.service.GameService;
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
	private final GameService gameService;

	public GameController(GameService gameService){
		this.gameService = gameService;
	}

	@GetMapping("/api/adventurers")
	public List<Adventurer> getAdventurers() {
		return gameService.getAdventurers();
	}
	

	@GetMapping("/api/game")
	public Map<String, Object> getGameStatus() {
		Party result = gameService.getParty();
		return Map.of(
				"gameName", "冒険者ギルド運営シミュレーター",
				"day", 1,
				"gold", 500,
				"members", result.getMembers(),
				"totalPower", result.getTotalPower(),
				"message", "ギルド運営を開始できます！"
			);
	}

	@PostMapping("/api/party")
	public Map<String, Object> createParty(@RequestBody List<Integer> ids) {
		
		Party result = gameService.createParty(ids);

		return Map.of(
			"members", result.getMembers(),
			"totalPower", result.getTotalPower()
		);
	}
	
}
