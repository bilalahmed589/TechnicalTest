package com.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Article;
import com.model.Author;
import com.model.JsonData;

/**
 * @author abilal
 *
 */
public class Process implements IProcess{
	
	private final Map<Author,HashMap<Author,Integer>> matrix = new HashMap<>();

	/**
	   * This method is used to calculate the co-author matrix .
	   * @param data This is de-serialized objectof input json
	   * @return Map This returns co-author matrix of input json 
	   */
	@Override
	public final Map<Author,HashMap<Author,Integer>> getMatrix(final JsonData data){
		for (Article article : data.getMedlineCitationSet().getArticle()) {
			searchCoAuthor(article.getAuthorList().getAuthor(),0);
		}
		
		return matrix;
	}
	/**
	 * This recursive method iterate through the authors of a article.
	 * After finding co-author this update the matrix map
	 * Note : this method can be changed to iteration from recursion
	 * Complexity for this method is n*log(n)  
	 * @param coauthors
	 * @param index
	 */
	private void searchCoAuthor(final List<Author> coauthors,int index){
		Author srcAuthor = coauthors.get(index);
		for(int outerIdx = index;outerIdx<coauthors.size();outerIdx++ ){
			Author author = coauthors.get(outerIdx);
			updateMatrixCount(srcAuthor,author);
			if(outerIdx != index){
				updateMatrixCount(author,srcAuthor);
			}
		}
		if(index < coauthors.size()-1){
			searchCoAuthor(coauthors,++index);
		}
	}
	
	/**
	 * increment matrix count at required author position
	 * if author X worked Y than both X,Y counter will be increased  
	 * @param srcAuthor
	 * @param author
	 */
	private void updateMatrixCount(final Author srcAuthor,final Author author){
		int count = 1;
		if(!matrix.containsKey(srcAuthor)){
			HashMap<Author, Integer> value = new HashMap<>();
			value.put(author, count);
			matrix.put(srcAuthor, value);
		}else if(matrix.containsKey(srcAuthor) && !matrix.get(srcAuthor).containsKey(author)){
			matrix.get(srcAuthor).put(author, count);
		}else{
			count = matrix.get(srcAuthor).get(author) + 1;
			matrix.get(srcAuthor).put(author, count);
		}
	}
	
	/*public List<Author> getAuthorList(final Example data){
		List<Article> articles = data.getMedlineCitationSet().getArticle();
		for (Article article : articles) {
			for (Author author : article.getAuthorList().getAuthor()) {
				if(!authors.contains(author)){
					authors.add(author);
				}
			}
		}
		return authors;
	}*/
}
