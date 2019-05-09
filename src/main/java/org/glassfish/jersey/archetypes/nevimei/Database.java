package org.glassfish.jersey.archetypes.nevimei;

import java.sql.*;
import java.util.ArrayList;
public class Database {
	
	static final String DBC_URL = "org.postgresql.Driver";
	
	
	
	Connection connect = null;
	
	public Connection getConnection() throws SQLException
	{
		try {
			Class.forName(DBC_URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RecipeDatabase", "postgres", "paradajka");
		return connect;
	}
	


	public ArrayList<Recipe> getRecipe(int category)
	{
		try {
			Class.forName(DBC_URL);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		//kvery
		String query = "select * from recipe join category on recipe.id_category = category.id_category where category.id_category = ?";
		try {
			Connection con;
			con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			get.setInt(1, category);
			ResultSet result = get.executeQuery();
			while(result.next()) 
			{
				int id = result.getInt("id_recipe");
				Recipe rec = new Recipe();
				rec.setName(result.getString("recipe_name"));
				rec.setDescription(result.getString("description"));
				rec.setPrepTime(result.getInt("prep_time"));
				rec.setServings(result.getInt("servings"));
				rec.setImg(result.getString("image"));
				get = con.prepareStatement("select step from direction where id_recipe = ?");
				get.setInt(1, id);
				ResultSet dirs = get.executeQuery();
				ArrayList<String> directions = new ArrayList<String>();
				while (dirs.next())
				{
					directions.add(dirs.getString("step"));
				}
				rec.setDirections(directions);
				
				get = con.prepareStatement("select ingredient_name from ingredient where id_recipe = ?");
				get.setInt(1, id);
				ResultSet ings = get.executeQuery();
				ArrayList<String> ingredients = new ArrayList<String>();
				while (ings.next())
				{
					ingredients.add(ings.getString("ingredient_name"));
				}
				rec.setIngredients(ingredients);
				recipes.add(rec);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block logger
			System.out.println("HIHI");
			e.printStackTrace();
		}
		return recipes;
	}
	
	
}
