package com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

@SerializedName("ArticleTitle")
@Expose
private String articleTitle;
@SerializedName("AuthorList")
@Expose
private AuthorList authorList;

public String getArticleTitle() {
return articleTitle;
}

public void setArticleTitle(String articleTitle) {
this.articleTitle = articleTitle;
}

public AuthorList getAuthorList() {
return authorList;
}

public void setAuthorList(AuthorList authorList) {
this.authorList = authorList;
}

}