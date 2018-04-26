package com.spring.project.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.spring.project.demo.domain.BattleResult;

import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonMove;

@Service
@Slf4j
public class BattleService {

	private BattleResult persistentResult;
	private int pokemonOneHP;
	private int pokemonTwoHP;

	public BattleResult startBattle(Pokemon pokemonOne, Pokemon pokemonTwo) {

		this.setPokemonOneHP(100);
		this.setPokemonTwoHP(100);

		BattleResult battleResult = new BattleResult();
		List<String> historyOne = new ArrayList<>();
		List<String> historyTwo = new ArrayList<>();
		battleResult.setPokemonOne(pokemonOne.getName());
		battleResult.setPokemonTwo(pokemonTwo.getName());
		battleResult.setPokemonOneMoveHisotry(historyOne);
		battleResult.setPokemonTwoMoveHistory(historyTwo);
		this.setPersistentResult(battleResult);

		while (!fightIsOver()) {
			attackPokemonOne(pokemonTwo);
			attackPokemonTwo(pokemonOne);
		}

		updateWinner(pokemonOne.getName(), pokemonTwo.getName());

		return this.persistentResult;
	}

	private void updateWinner(String one, String two) {
		if (this.getPokemonOneHP() >= this.getPokemonTwoHP()) {
			this.persistentResult.setWinnerPokemon(one);
			this.persistentResult.setLoserPokemon(two);
		} else {
			this.persistentResult.setWinnerPokemon(two);
			this.persistentResult.setLoserPokemon(one);
		}

	}

	private void attackPokemonTwo(Pokemon pokemonOne) {
		int maxSize = pokemonOne.getMoves().size();
		Random rand = new Random();
		PokemonMove move = pokemonOne.getMoves().get(rand.nextInt(maxSize));
		this.getPersistentResult().getPokemonOneMoveHisotry().add(move.component1().getName());
		// Randomly generate HP drain since I couldn't get this info from pokemonMove
		// 1 - 100
		int hpDrain = rand.nextInt(100);
		this.setPokemonTwoHP(this.getPokemonTwoHP() - hpDrain);
		return;
	}

	private void attackPokemonOne(Pokemon pokemonTwo) {
		int maxSize = pokemonTwo.getMoves().size();
		Random rand = new Random();
		PokemonMove move = pokemonTwo.getMoves().get(rand.nextInt(maxSize));
		this.getPersistentResult().getPokemonTwoMoveHistory().add(move.component1().getName());
		// Randomly generate HP drain since I couldn't get this info from pokemonMove
		// 1 - 100
		int hpDrain = rand.nextInt(100);
		this.setPokemonOneHP(this.getPokemonOneHP() - hpDrain);
		return;

	}

	private boolean fightIsOver() {
		if (this.getPokemonOneHP() <= 0 || this.getPokemonTwoHP() <= 0) {
			return true;
		}
		return false;
	}

	public BattleResult getPersistentResult() {
		return persistentResult;
	}

	public void setPersistentResult(BattleResult persistentResult) {
		this.persistentResult = persistentResult;
	}

	public int getPokemonOneHP() {
		return pokemonOneHP;
	}

	public void setPokemonOneHP(int pokemonOneHP) {
		this.pokemonOneHP = pokemonOneHP;
	}

	public int getPokemonTwoHP() {
		return pokemonTwoHP;
	}

	public void setPokemonTwoHP(int pokemonTwoHP) {
		this.pokemonTwoHP = pokemonTwoHP;
	}

}
