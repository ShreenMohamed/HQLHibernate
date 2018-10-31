package hqlhiber;

import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Crud {
	public void insert(){
		Session se =NewHibernateUtil.getSessionFactory().openSession();
try{
	se.beginTransaction();
Person p =new Person();
p.setName("adham");
p.setJobTitle("manager");
p.setPosition("senior");
p.setSalary(1000);
Person p2 =new Person();
p2.setName("shery");
p2.setJobTitle("manager");
p2.setPosition("senior");
p2.setSalary(2000);
se.save(p);
se.save(p2);
Person p3 =new Person();
p3.setName("osama");
p3.setJobTitle("manager");
p3.setPosition("senior");
p3.setSalary(6000);
se.save(p3);
Person p4 =new Person();
p4.setName("mona");
p4.setJobTitle("manager");
p4.setPosition("senior");
p4.setSalary(6000);
se.save(p4);
Person p5 =new Person();
p5.setName("ahmed");
p5.setJobTitle("manager");
p5.setPosition("senior");
p5.setSalary(100000);
se.save(p5);

/*
Transaction tx =se.beginTransaction();
se.save(new Employee("maya",1000));
se.save(new Employee("ma",2000));
tx.commit();

*/
	
	// to insert in database
	se.getTransaction().commit();
	
}catch(HibernateException e){
	se.getTransaction().rollback();
	e.printStackTrace();
	
}
	finally{
		
		se.close();
	}}
	
	
	
	
	

	

public static void insert (String name, boolean activated , Session se){

try{
se.beginTransaction();
St a = new St(name,activated);
se.save(a);



// to insert in database
se.getTransaction().commit();

}catch(HibernateException e){
se.getTransaction().rollback();
e.printStackTrace();

}
finally{
	
}}
	
	
	
	
	
	
	
	public void select(){
		Session se =NewHibernateUtil.getSessionFactory().openSession();
try{
	se.beginTransaction();
	//(using hql)
	//to select 
	//from+name of entity
	/*String hql = "FROM Person";
	Query q = se.createQuery(hql);
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/
	/*
	// if i want constant number of rows use something called paingtation
	String hql = "FROM Person";
	Query q = se.createQuery(hql);
	q.setFirstResult(3);
	q.setMaxResults(1);
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/
	
	

	// if i want order by 
	/*String hql = "FROM Person p order by p.name desc";
	Query q = se.createQuery(hql);
	
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
	}*/
	
	//select one row
	//String hql = "FROM Person where name='osama' and salary=6000";
	/*String hql = "FROM Person where name=? and salary=?";
	Query q = se.createQuery(hql);
	q.setString(0,"osama");
	q.setInteger(1,6000);
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/
	
	
	/*String hql = "FROM Person where name=:n and salary=:s";
	Query q = se.createQuery(hql);
	q.setString("n","osama");
	q.setInteger("s",6000);
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/

	
	//take field from user
	/*String hql = "FROM Person where name=? and salary=?";
	Person d =new Person();
	d.setName("ahmed");
	d.setSalary(6000);
	Query q = se.createQuery(hql);
	q.setParameter(0,d.getName());
	q.setParameter(1,d.getSalary());
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/
	
	
	
	//aggregate method (min,max,sum,count,...)
	/*
	String hql = "select max(salary) FROM Person";
	String hql2 = "select min(salary) FROM Person";
	String hql3 = "select sum(salary) FROM Person";
	String hql4 = "select avg(salary) FROM Person";
	String hql5 = "select count(salary) FROM Person";
	String hql6 = "select count(distinct salary) FROM Person";
	Query q = se.createQuery(hql);
	System.out.println("salary= "+q.list().toString());

	Query u = se.createQuery(hql2);
	System.out.println("salary= "+u.list().toString());


	Query e = se.createQuery(hql3);
	System.out.println("salary= "+e.list().toString());

	Query j = se.createQuery(hql4);
	System.out.println("salary= "+j.list().toString());

	Query o = se.createQuery(hql5);
	System.out.println("salary= "+o.list().toString());

	Query t = se.createQuery(hql6);
	System.out.println("salary= "+t.list().toString());
	

	Query h = se.createQuery(hql5);
	System.out.println("salary= "+h.list().toString());*/
	
	//-----------------------------------------------------------------------
	// (using criteria)
	
	/*Criteria q = se.createCriteria(Person.class);
	Person r=new Person();
	r.setSalary(6000);*/
	//q.setFirstResult(0);
	//q.setMaxResults(1);
	
	//q.addOrder(Order.asc("salary"));
	//q.addOrder(Order.desc("salary"));
	
	//Resteiction is condition
	//gt >greater than
	//q.add(Restrictions.gt("salary", 1000));
	//q.add(Restrictions.gt("salary", r.getSalary()));
	
	
	//ge >greater than or equal
	//q.add(Restrictions.ge("salary", r.getSalary()));
	
	//lt >lessthan
	//q.add(Restrictions.lt("salary", r.getSalary()));
	

	//le >lessthan or equal
	//q.add(Restrictions.le("salary", r.getSalary()));
	
	
	//q.add(Restrictions.between("salary",2000,10000));
	
	/*Integer[] t ={1000,2000,6000};
	q.add(Restrictions.in("salary",t));*/
	
	
	//q.add(Restrictions.isNull("name"));
	
	//q.add(Restrictions.isNotNull("name"));
	
	/*
	//equal
	r.setName("adham");
	q.add(Restrictions.eq("name",r.getName()));*/
	

	/*//notequal
	r.setName("adham");
	q.add(Restrictions.ne("name",r.getName()));*/
	
	/*//like
	q.add(Restrictions.like("name","a",MatchMode.START));
	q.add(Restrictions.like("name","a",MatchMode.END));
	q.add(Restrictions.like("name","a",MatchMode.ANYWHERE));*/
/*
	
	//ilike notcasesenstive
		q.add(Restrictions.ilike("name","a",MatchMode.START));
		q.add(Restrictions.ilike("name","a",MatchMode.END));
		q.add(Restrictions.ilike("name","a",MatchMode.ANYWHERE));
	List <Person> per = q.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
	
	
	}*/
	
	//and or aggregate
/*
	Criteria c = se.createCriteria(Person.class);
	Criterion c1=Restrictions.like("name","a",MatchMode.START);
	Criterion c2=Restrictions.eq("salary",6000);
	//LogicalExpression and =Restrictions.and(c1,c2);
	//c.add(and);
	LogicalExpression or =Restrictions.or(c1,c2);
    c.add(or);
	
    Criteria max =c.setProjection(Projections.max("salary"));
    System.out.println("max= "+max.list().toString());
    

    Criteria min =c.setProjection(Projections.min("salary"));
    System.out.println("min= "+min.list().toString());
    

    Criteria avg =c.setProjection(Projections.avg("salary"));
    System.out.println("avg= "+avg.list().toString());
    

    Criteria sum =c.setProjection(Projections.sum("salary"));
    System.out.println("sum= "+sum.list().toString());
    

    Criteria count =c.setProjection(Projections.count("salary"));
    System.out.println("count= "+count.list().toString());
	

    Criteria countDistinct =c.setProjection(Projections.countDistinct("salary"));
    System.out.println("countDistinct= "+countDistinct.list().toString());
    

    Criteria rowcount =c.setProjection(Projections.rowCount());
    System.out.println("rowcount= "+rowcount.list().toString());
	*/
	
	/*
	//namedquery
	Person d =new Person();
	d.setName("ahmed");
	// (byname) the same name in query in entity
	Query n = se.getNamedQuery("byname");
	n.setString(0,d.getName());
	List <Person> per = n.list();
	for(Person p :per){
		System.out.println("id= "+p.getId());
		System.out.println("name= "+p.getName());
		System.out.println("title= "+p.getJobTitle());
		System.out.println("salary= "+p.getSalary());
		System.out.println("position= "+p.getPosition());
		
	}*/
	
	//query in vision
	Query q =se.createQuery("update Person  set name=:n ,ver=:v" + "where id=:id and ver=:e");
	
	q.setString("n", "sara");
	q.setInteger("v", 1);
	q.setInteger("id", 1);
	q.setInteger("e", 1);
	q.executeUpdate();
	

	Query q2 =se.createQuery("update Person  set name=:n ,ver=:v" + "where id=:id and ver=:e");
	
	q2.setString("n", "ali");
	q2.setInteger("v", 1);
	q2.setInteger("id", 1);
	q2.setInteger("e", 1);
	q2.executeUpdate();
	
	
	
	// to insert in database
	se.getTransaction().commit();
	
}catch(HibernateException e){
	se.getTransaction().rollback();
	e.printStackTrace();
	
}
	finally{
		
		se.close();
	}}
	
	
	
	
	
	
	public void update(){
		Session se =NewHibernateUtil.getSessionFactory().openSession();
try{
	se.beginTransaction();

	// to insert in database
	se.getTransaction().commit();
	
}catch(HibernateException e){
	se.getTransaction().rollback();
	e.printStackTrace();
	
}
	finally{
		
		se.close();
	}}
	
	
	
	public void delete(){
		Session se =NewHibernateUtil.getSessionFactory().openSession();
try{
	se.beginTransaction();

	// to insert in database
	se.getTransaction().commit();
	
}catch(HibernateException e){
	se.getTransaction().rollback();
	e.printStackTrace();
	
}
	finally{
		
		se.close();
	}}
	
	

}
