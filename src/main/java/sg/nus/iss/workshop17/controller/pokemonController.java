package sg.nus.iss.workshop17.controller;


import java.util.logging.Logger;
import java.util.logging.Level;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.nus.iss.workshop17.model.Pokemon;
import sg.nus.iss.workshop17.service.pokemonService;


@Controller
@RequestMapping(path="/pokemon")
public class pokemonController {
    Logger logger = Logger.getLogger(pokemonController.class.getName());
    
    @Autowired
    pokemonService service;

    @GetMapping
    public String showSearchPage(){
        return "index";
    }

    @GetMapping(path="/search")
    public String searchPokemon(@RequestParam("pokemon_name") String pokemonName, Model model){
        Pokemon pokemon = service.getPokemon(pokemonName);
        logger.log(Level.INFO, "Pokemon " + pokemon.getName() + " created.");
        if (pokemon.getName() == null){
            return "error";
        } else {
            model.addAttribute("pokemon", pokemon);
            return "showPokemon";
    }
        
    }

}
