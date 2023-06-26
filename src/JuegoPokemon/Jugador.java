package JuegoPokemon;

public class Jugador {

	public Pokemon[] pokemons;
	public Pokemon pokemonTitular;
	
	public Jugador(Pokemon[] pokemon, Pokemon pokemonTitular) {
		for (int i = 0; i < 3; i++) {
			this.pokemons[i] = pokemon[i];
		}
		
		this.pokemonTitular = pokemonTitular;
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}

	public void setPokemons(Pokemon[] pokemons) {
		this.pokemons = pokemons;
	}
	
	public void setPokemonTitular() {
		
	}

	public Pokemon getPokemonTitular() {
		return pokemonTitular;
	}

	public void setPokemonTitular(Pokemon pokemonTitular) {
		this.pokemonTitular = pokemonTitular;
	}
}
