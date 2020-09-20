package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.example.query.service.QueryService;
import com.example.query.service.QueryServiceImpl;
import com.example.query.service.SqueryEntity;
 
public class QueryServiceTest  {

	 
	 private  static QueryService   queryService  = new QueryServiceImpl();;
 

   @Test
   public void TestQuery(){
	    
	   	 List<SqueryEntity>  lists = genLists(100000); 
	   	
		 Comparator<SqueryEntity> orderBy = Comparator.comparing(SqueryEntity::getLevel) ;
		 Predicate<SqueryEntity>  where=(SqueryEntity w) -> w.getId() ==1 && w.getId() ==1;
		 Function<SqueryEntity,String> groupBy =(SqueryEntity g)-> g.getId()  +"#"+  g.getName() ;
		 
		 List<SqueryEntity> resultList = queryService.queryList(lists, where,  groupBy,orderBy,10 );
		 resultList = queryService.queryList(lists, null,  groupBy,orderBy,10 );
		 resultList = queryService.queryList(lists, null,  null,  null,10 );
		 resultList.forEach(data -> {
			    System.out.println(JSON.toJSON(data).toString());
			});
		 
		 
   }
   
   @Test
   public void TestGroup(){
	    
	   	 List<SqueryEntity>  lists = genLists(100); 
	   	 
		 Function<SqueryEntity,String> groupBy =(SqueryEntity g)-> g.getId()  +"#"+  g.getName() ; 
		 List<SqueryEntity> resultList = queryService.queryList(lists, null,  groupBy,null,-1);
		 
		 resultList.forEach(data -> {
			    System.out.println(JSON.toJSON(data).toString());
			});
		 
		 
   }
   
   @Test
   public void TestWhere(){
	    
	   	 List<SqueryEntity>  lists = genLists(1000); 
	   	 
		 Predicate<SqueryEntity>  where=(SqueryEntity w) -> w.getId() ==1 && w.getId() ==1; 
		 List<SqueryEntity> resultList = queryService.queryList(lists, where,  null,null,10);
		 
		 resultList.forEach(data -> {
			    System.out.println(JSON.toJSON(data).toString());
			});
		 
		 
   }
   
   @Test
   public void TestOrderBy(){
	    
	   	 List<SqueryEntity>  lists = genLists(1000); 
	   	 
	   	 Comparator<SqueryEntity> orderBy = Comparator.comparing(SqueryEntity::getLevel) ; 
		 List<SqueryEntity> resultList = queryService.queryList(lists, null, null ,orderBy,10);
		 
		 resultList.forEach(data -> {
			    System.out.println(JSON.toJSON(data).toString());
			});
		 
		 
   }
   
   private    List<SqueryEntity> genLists(int amount){
	   List<SqueryEntity>  lists = new ArrayList<SqueryEntity>();
		
		 for(int i=0;i<amount;i++) {
			 SqueryEntity entity = new SqueryEntity();
				entity.setId(i);
				entity.setName("Alan" );
				entity.setLevel(( amount-i)  );
				entity.setAddress("x3");
				lists.add(entity);
		 }
		 
		 for(int i=0;i<amount;i++) {
			 SqueryEntity entity = new SqueryEntity();
				entity.setId(i);
				entity.setName( "Dave");
				entity.setLevel(( amount -i+1) );
				entity.setAddress("x1");
				lists.add(entity);
		 }
		 for(int i=0;i<amount;i++) {
			 SqueryEntity entity = new SqueryEntity();
				entity.setId(i);
				entity.setName( "Zara");
				entity.setLevel(( amount-i+2) );
				entity.setAddress("x2");
				lists.add(entity);
		 }
		 return lists;
   }

}
