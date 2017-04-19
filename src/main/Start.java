package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonParseException;
import com.model.Author;
import com.model.JsonData;
import com.processor.IProcess;
import com.processor.Process;
import com.writer.ConsoleWriter;
import com.writer.Writer;

import parser.Parse;

public class Start {

	public static void main(String[] args) {
//		Load file and parse JSON into objects
		JsonData data = null;
		try {
			data = Parse.getParse().getJsonFromFile();
		} catch (IllegalStateException | JsonParseException | NullPointerException | IOException e) {
			System.out.println("Error in parsing json : " + e.getMessage());
			System.exit(0);
		} 
		
//		Process input data and get matrix 
		final IProcess processor = new Process();
		final Map<Author, HashMap<Author, Integer>> matrix =  processor.getMatrix(data);
		
//		Print the matrix
		final Writer writer = new ConsoleWriter();
		writer.print(matrix);

	}

}
