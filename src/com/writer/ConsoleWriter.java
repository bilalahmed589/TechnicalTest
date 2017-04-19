package com.writer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.model.Author;

public class ConsoleWriter implements Writer {
	
	/**
	   * This method is used to print output on console.
	   * @param matrix This is a Map contains all the matrix including author names as key
	   */
	@Override
	public final void print(final  Map<Author, HashMap<Author, Integer>> matrix){
		final TreeSet<Author> authors = new TreeSet<Author>(matrix.keySet());
		printAuthors(authors);

		for (Author author : authors) {
			System.out.printf("%1s ", printableName(author) );
			int padding=1;
			for (Author author2 : authors) {
				if(matrix.get(author).containsKey(author2)  ){
					if(padding ==1){
						padding = 20-printableName(author).length();
					}else{
						padding=15;
					}
					System.out.printf("%" + padding + "d", matrix.get(author).get(author2));					
				}else{
					if(padding ==1){
						padding = 20-printableName(author).length();
					}else{
						padding=15;
					}
					System.out.printf("%" + padding + "d", 0);
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	private void printAuthors(Set<Author> authorList){
		System.out.printf("%10s ", "");
		for (Author author : authorList) {
			int padding = 14;//-author.getForeName().length();
			System.out.printf("%" + padding + "s ", (author.getForeName()) );
		}
		System.out.println();
		System.out.printf("%10s ", "");
		for (Author author : authorList) {
			int padding = 14;//-author.getLastName().length();
			System.out.printf("%" + padding + "s ", (author.getLastName()) );
		}
		System.out.println();
		System.out.println();
	}
	
	private String printableName(Author author){
		return author.getForeName() + " " + author.getLastName();
	}
}
