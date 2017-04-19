package com.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthorList {

@SerializedName("Author")
@Expose
private List<Author> author = null;

public List<Author> getAuthor() {
return author;
}

public void setAuthor(List<Author> author) {
this.author = author;
}

}