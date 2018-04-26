package com.spring.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.demo.domain.Battle;
import com.spring.project.demo.domain.BattleResult;
import com.spring.project.demo.service.BattleService;

import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonMove;

@RestController
@Slf4j
public class PokemonController {

	@Autowired
	private PokeApiClient pokeApiClient;

	@Autowired
	private BattleService battleService;

	@RequestMapping(path = "/pokemon/{id}")
	public Pokemon getPokemon(@RequestParam(value = "id", defaultValue = "1") int id) {
		// PokeApi pokeApi = new PokeApiClient();
		Pokemon pokemon = pokeApiClient.getPokemon(id);
		return pokemon;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/pokemon/{id}/attack/{attackId}")
	public PokemonMove getAttack(@RequestParam(value = "id", defaultValue = "1") int id,
			@RequestParam(value = "attackId", defaultValue = "1") int attackId) {
		// PokeApi pokeApi = new PokeApiClient();
		Pokemon pokemon = pokeApiClient.getPokemon(id);
		List<PokemonMove> moves = pokemon.getMoves();
		return moves.get(attackId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/battle")
	public BattleResult postBattle(@RequestBody Battle battle) {
		// PokeApi pokeApi = new PokeApiClient();
		Pokemon pokemonOne = pokeApiClient.getPokemon(battle.getPokemonOneId());
		Pokemon pokemonTwo = pokeApiClient.getPokemon(battle.getPokemonTwoId());
		;
		return battleService.startBattle(pokemonOne, pokemonTwo);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/battle/{id}")
	public Object getBattle() {
		return null;
	}
}
