package sg.nus.iss.workshop17.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.nus.iss.workshop17.model.Pokemon;

@Service
public class pokemonService {
    
    public JsonObject loadPokemon (String pokemonName){
        // RequestEntity<Void> req = RequestEntity
        //     .get("https://pokeapi.co/api/v2/pokemon/"+ pokemonName)
        //     .accept(MediaType.APPLICATION_JSON)
        //     .build();
        // RestTemplate template = new RestTemplate();
        // ResponseEntity<String> resp = template.exchange(req, String.class);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.getForEntity("https://pokeapi.co/api/v2/pokemon/"+ pokemonName, String.class);


        InputStream is = new ByteArrayInputStream(resp.getBody().getBytes());
        JsonReader reader = Json.createReader(is);
        JsonObject data = reader.readObject();

        return data;
    }

    public Pokemon getPokemon (String pokemonName){
        Pokemon pokemon = new Pokemon();
        try{
            pokemon = Pokemon.create(loadPokemon(pokemonName));
        } catch (Exception e){
            e.printStackTrace();
        }
        return pokemon;
    }

}
