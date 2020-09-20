QueryServiceTest为测试类
QueryServiceImpl：queryList为功能实现
\target\site\jacoco\index.html为覆盖率报告

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