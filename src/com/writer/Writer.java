package com.writer;

import java.util.HashMap;
import java.util.Map;

import com.model.Author;

public interface Writer {
	public void print(final  Map<Author, HashMap<Author, Integer>> matrix);
}
