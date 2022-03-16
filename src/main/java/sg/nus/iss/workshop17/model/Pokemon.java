package sg.nus.iss.workshop17.model;

import jakarta.json.JsonObject;

public class Pokemon {
    private String name;
    private String back_default;
    private String back_gray;
    private String back_transparent;
    private String front_default;
    private String front_gray;
    private String front_transparent;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBack_default() {
        return back_default;
    }
    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }
    public String getBack_gray() {
        return back_gray;
    }
    public void setBack_gray(String back_gray) {
        this.back_gray = back_gray;
    }
    public String getBack_transparent() {
        return back_transparent;
    }
    public void setBack_transparent(String back_transparent) {
        this.back_transparent = back_transparent;
    }
    public String getFront_default() {
        return front_default;
    }
    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
    public String getFront_gray() {
        return front_gray;
    }
    public void setFront_gray(String front_gray) {
        this.front_gray = front_gray;
    }
    public String getFront_transparent() {
        return front_transparent;
    }
    public void setFront_transparent(String front_transparent) {
        this.front_transparent = front_transparent;
    }
    
    public static Pokemon create(JsonObject pokemon){
        Pokemon p = new Pokemon();
        p.setName( (String) pokemon.getString("name"));
        p.setBack_default((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("back_default"));
        p.setBack_gray((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("back_gray"));
        p.setBack_transparent((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("back_transparent"));
        p.setFront_default((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("front_default"));
        p.setFront_gray((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("front_gray"));
        p.setFront_transparent((String) pokemon.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getString("front_transparent"));

        return p;
    }
}
