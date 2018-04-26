package com.spring.project.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class BattleResult {
	
	private String winnerPokemon;
	private String loserPokemon;
	private String pokemonOne;
	private String pokemonTwo;
	List<String> pokemonOneMoveHisotry;
	List<String> pokemonTwoMoveHistory;
	
	public List<String> getPokemonOneMoveHisotry() {
		return pokemonOneMoveHisotry;
	}
	public void setPokemonOneMoveHisotry(List<String> pokemonOneMoveHisotry) {
		this.pokemonOneMoveHisotry = pokemonOneMoveHisotry;
	}
	public List<String> getPokemonTwoMoveHistory() {
		return pokemonTwoMoveHistory;
	}

	public void setPokemonTwoMoveHistory(List<String> pokemonTwoMoveHistory) {
		this.pokemonTwoMoveHistory = pokemonTwoMoveHistory;
	}
	public String getWinnerPokemon() {
		return winnerPokemon;
	}
	public void setWinnerPokemon(String winnerPokemon) {
		this.winnerPokemon = winnerPokemon;
	}
	public String getLoserPokemon() {
		return loserPokemon;
	}
	public void setLoserPokemon(String loserPokemon) {
		this.loserPokemon = loserPokemon;
	}
	public String getPokemonOne() {
		return pokemonOne;
	}
	public void setPokemonOne(String pokemonOne) {
		this.pokemonOne = pokemonOne;
	}
	public String getPokemonTwo() {
		return pokemonTwo;
	}
	public void setPokemonTwo(String pokemonTwo) {
		this.pokemonTwo = pokemonTwo;
	}

	
	
}
