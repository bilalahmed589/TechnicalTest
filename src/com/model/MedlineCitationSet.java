package com.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedlineCitationSet {

	@SerializedName("Article")
	@Expose
	private List<Article> article = null;
	
	public List<Article> getArticle() {
	return article;
	}
	
	public void setArticle(List<Article> article) {
	this.article = article;
	}

}