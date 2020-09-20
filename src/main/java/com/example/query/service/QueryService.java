package com.example.query.service;


import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface QueryService  {
	public   <T> List<T> queryList(List<T> list, Predicate<T>  where, Function<T,String> groupBy,Comparator<T> orderBy,int limit  );
}
  
