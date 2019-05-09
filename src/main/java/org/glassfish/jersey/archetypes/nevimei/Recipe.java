package org.glassfish.jersey.archetypes.nevimei;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Recipe {
	
	private String name;
	private String img;
	private String description;
	private ArrayList<String> ingredients;
	private int prepTime;
	private int servings;
	
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	public ArrayList<String> getDirections() {
		return directions;
	}
	public void setDirections(ArrayList<String> directions) {
		this.directions = directions;
	}
	private ArrayList<String> directions;

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	
}
