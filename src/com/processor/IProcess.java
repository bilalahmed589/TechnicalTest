package com.processor;

import java.util.HashMap;
import java.util.Map;

import com.model.Author;
import com.model.JsonData;

/**
 * @author abilal
 *
 */
public interface IProcess {
	
	public Map<Author,HashMap<Author,Integer>> getMatrix(final JsonData data);
}
