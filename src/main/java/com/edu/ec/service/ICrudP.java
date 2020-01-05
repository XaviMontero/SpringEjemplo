package com.edu.ec.service;

import java.util.List;

public interface ICrudP  <T> {
	T save (T obj); 
	T update (T obj); 
	List<T> list(); 
	boolean eliminar (String id); 
	T getOne(String id);
}
