# pokeApiDemo

Demo project to connect to pokemon api (https://pokeapi.co)

## Getting Started

### Prerequisites

Java, Maven

### Installing

```
git clone https://github.com/kshean/pokeApiDemo.git
```


## Running the application

```
mvn clean spring-boot:run
```

### Endpoints
Using your favorite http client, make the following requests.

#### Get pokemon

sameple request:
```
GET localhost:8080/pokemon/1

```

sample response:
```
{
    "id": 1,
    "name": "bulbasaur",
    "baseExperience": 64,
    "height": 7,
    "order": 1,
    "weight": 69,
    "species": {
        "name": "bulbasaur",
        "category": "pokemon-species",
        "id": 1
    },
    "abilities": [
        
...omitted...
      
}
```


#### Get attack

sameple request:
```
GET localhost:8080/pokemon/1/attack/2

```

sample response:
```
{
    "move": {
        "name": "swords-dance",
        "category": "move",
        "id": 14
    },
    "versionGroupDetails": [
        {
            "moveLearnMethod": {
                "name": "machine",
                "category": "move-learn-method",
                "id": 4
            },
            "versionGroup": {
                "name": "sun-moon",
                "category": "version-group",
...omitted...
    ]
}
```

#### Post battle

sample response:
```
POST localhost:8080/battle

{
	"pokemonOneId": 1,
	"pokemonTwoId": 2
}
```

sameple request:
```
{
    "winnerPokemon": "bulbasaur",
    "loserPokemon": "ivysaur",
    "pokemonOne": "bulbasaur",
    "pokemonTwo": "ivysaur",
    "pokemonOneMoveHisotry": [
        "synthesis",
        "swords-dance"
    ],
    "pokemonTwoMoveHistory": [
        "sunny-day",
        "solar-beam"
    ]
}

```

### Assumptions
I was not able to find drainHP from the attack class. Therefore, each attack has a randomnly generated drainHP associated between 1 to 100.


### Technologies
pokeApiCleint: Kotlin (and Java) - PokeKotlin by sargunster (https://github.com/PokeAPI/pokekotlin),
Java 8,
maven,
Spring-boot,
Spring Initializer (https://start.spring.io/)