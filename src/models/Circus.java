package models;

import jsonparserapi.JSONConnection;
import jsonparserapi.JSONObject;

import java.io.IOException;

public class Circus {

	
	private int id;
	private String name;
	private Country country;
	private String description;
	private String picture;
	private boolean genuine;
	
	
	public Circus(int id, String name, Country country, String description, String picture, boolean genuine){
		this.id = id;
		this.name = name;
		this.country = country;
		this.description = description;
		this.picture = picture;
		this.genuine = genuine;
	}
	
	//Mehodes
	public void addCircus(){
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/add_circus.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&name=" +
                this.name +
                "&country=" +
                this.country +
                "&description=" +
                this.description;

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
        }
        else{
            this.setId(jsonObject.getInt("id"));
            System.out.println("Successfull !!");
        }
	}

    public void updateCircus(){

    }
	
	public void deleteCircus(){
		
	}
    //TODO : Enlever les commentaires
    public void getCircus(int id) throws IOException {
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
        }
        else{
            this.setId(jsonObject.getInt("id"));
            this.setName(jsonObject.getString("name"));
            //Country.getCountry have not been coded
            //this.setPicture(new Country().getCountry(jsonObject.getString("country")));
            this.setDescription(jsonObject.getString("description"));
            this.setGenuine(jsonObject.getBoolean("genuine"));
            this.setPicture(jsonObject.getString("picture"));
        }
    }
	
	//Getters
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}
	
	public String getPicture(){
		return picture;
	}
	
	public boolean getGenuine(){
		return genuine;
	}
	
	//Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
		this.name = name;
	}

	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPicture(String picture){
		this.picture = picture;
	}
	
	public void setGenuine(boolean genuine){
		this.genuine = genuine;
	}	
	
}
