QueryServiceTestΪ������
QueryServiceImpl��queryListΪ����ʵ��
\target\site\jacoco\index.htmlΪ�����ʱ���

 /**
     * ����������ѯ�б�
     *
     * @param list: �Ը�list���в�ѯ;
     * @param where:��ѯ��������:where=(SqueryEntity w) -> w.getId() ==1 && w.getId() ==1;
     * @param groupBy:���� ����:vgroupBy=(SqueryEntity g)-> g.getId()  +"#"+  g.getName();
     * @param orderBy:������:orderBy=Comparator.comparing(SqueryEntity::getId);
     * @param limit:��󷵻ؽ����  ;
     * @return List<T> ��ѯ��� 
     */
	@Override
	public <T> List<T> queryList(List<T> list, Predicate<T> where, Function<T, String> groupBy, Comparator<T> orderBy, int limit) {