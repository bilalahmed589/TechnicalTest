package parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.model.JsonData;

import main.Start;
/**
 * 
 * @author abilal
 * Singleton class to read and parse JSON
 */
public class Parse {

	private static Parse instance;
	
	private Parse(){
	}
	
	public static Parse getParse(){
		if(instance == null){
			return new Parse();
		}else{
			return instance;
		}
	}
	public JsonData getJsonFromFile() throws IllegalStateException,JsonParseException,IOException{
		Reader reader = new InputStreamReader(Start.class.getResourceAsStream("/example.json.txt"), "UTF-8");
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(reader, JsonData.class);
	}
}
