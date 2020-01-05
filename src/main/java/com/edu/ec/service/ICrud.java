package com.edu.ec.service;

import java.util.List;

public interface ICrud <T> {
	T save (T obj); 
	T update (T obj); 
	List<T> list(); 
	boolean eliminar (Integer id); 
	T getOne(Integer id);
}

