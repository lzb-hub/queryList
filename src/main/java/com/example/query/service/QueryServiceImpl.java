package com.example.query.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

 @Service
public class QueryServiceImpl implements QueryService {

	 /**
     * 根据条件查询列表
     *
     * @param list: 对改list进行查询;
     * @param where:查询条件，如:where=(SqueryEntity w) -> w.getId() ==1 && w.getId() ==1;
     * @param groupBy:分组 ，如:vgroupBy=(SqueryEntity g)-> g.getId()  +"#"+  g.getName();
     * @param orderBy:排序，如:orderBy=Comparator.comparing(SqueryEntity::getId);
     * @param limit:最大返回结果数  ;
     * @return List<T> 查询结果 
     */
	@Override
	public <T> List<T> queryList(List<T> list, Predicate<T> where, Function<T, String> groupBy, Comparator<T> orderBy, int limit) {
		 long startTime = System.currentTimeMillis();
	
		  List<T> result = new ArrayList<>();
		    if(where != null ) {
			    for(T e: list){
			        if(where.test(e)){
			            result.add(e);
			        }
			    }
		    }else {
		    	result = list;
		    }
		    if(orderBy != null ) {
		    	 result =list.stream().sorted(orderBy).collect(Collectors.toList()); 
		    }
		    
		    List<T> grouped = new ArrayList<>();
		    if(groupBy != null ) { 
		    	 Map<String, List<T >> groupedMap = result.stream()
		 				.collect(Collectors.groupingBy( groupBy ) ) ;
		    	 for (Map.Entry<String,List<T>> entry : groupedMap.entrySet()){
		    		 grouped.add(entry.getValue().get(0));
		    		} 
		    	 if(orderBy!=null) {
		    	
			    	  grouped =grouped.stream().sorted(orderBy).collect(Collectors.toList()); 
		    	 }
		    
		    } else {
		    	grouped =result;
		    }
		   if( limit> 0 &&  limit < grouped.size() ) {
			  grouped = grouped.subList(0, limit);
		   } 
			// 输出字符串
			System.out.println( "queryList finished and cost:" +(System.currentTimeMillis() - startTime));
		    return grouped;
	 
	}
 
}
  
