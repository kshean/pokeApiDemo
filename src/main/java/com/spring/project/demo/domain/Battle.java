package com.spring.project.demo.domain;

import lombok.Data;

@Data
public class Battle {

	private int pokemonOneId;
	private int pokemonTwoId;

	public int getPokemonOneId() {
		return pokemonOneId;
	}

	public void setPokemonOneId(int pokemonOneId) {
		this.pokemonOneId = pokemonOneId;
	}

	public int getPokemonTwoId() {
		return pokemonTwoId;
	}

	public void setPokemonTwoId(int pokemonTwoId) {
		this.pokemonTwoId = pokemonTwoId;
	}

}
