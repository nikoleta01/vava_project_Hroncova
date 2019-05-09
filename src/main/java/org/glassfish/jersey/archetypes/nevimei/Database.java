package org.glassfish.jersey.archetypes.nevimei;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Database {
	
	static final String DBC_URL = "org.postgresql.Driver";
	//logger config from
	//https://stackoverflow.com/questions/15758685/how-to-write-logs-in-text-file-when-using-java-util-logging-logger/22984168?fbclid=IwAR0qhEA0e6DyKTWArF4SZCBm4q3w1Qnf2Xx00q62qm13BEu57TbdR9_5b-c
	Logger logger = Logger.getLogger(Database.class.getName());
	
	Connection connect = null;
	
	public Connection getConnection() throws SQLException
	{
		try {
			Class.forName(DBC_URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "jdbc driver not found", e);
		}
		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RecipeDatabase", "postgres", "paradajka");
		return connect;
	}
	


	public ArrayList<Recipe> getRecipe(int category)
	{
        FileHandler fh;  
        try {  

            // This block configure the logger with handler and formatter  
            fh = new FileHandler("C:\\Users\\Dell\\Desktop\\eclipse\\eclipse-workspace666\\nevimei\\log\\logger.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  

        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
		
		try {
			Class.forName(DBC_URL);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "jdbc driver not found", e1);
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
			logger.log(Level.WARNING, "sql exception thrown", e);
		}
		return recipes;
	}
	
	
}
