package hqlhiber;

import java.util.Iterator;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class First {

	public static void main(String[] args) {
Crud c=new Crud();
c.insert();
//c.select();
//c.update();
//c.delete();
	


/*
//example of filter
Session se =NewHibernateUtil.getSessionFactory().openSession();

Crud.insert("maram",true,se);
Crud.insert("shee",true,se);
Crud.insert("hee",false,se);
Crud.insert("mee",false,se);
//show all users
System.out.println("show all user");
displayUsers(se);
//show activated filter
//"activatedFilter" is name of filter in st class
//"activatedParam" is name of filterparameter  in st class

Filter filter= se.enableFilter("activatedFilter");
//Filter filter= se.disableFilter("activatedFilter");


filter.setParameter("activatedParam", new Boolean(true));

System.out.println("--ACTIVIATED USERS--");
displayUsers(se);
	
//show  non activated filter

filter.setParameter("activatedParam", new Boolean(false));

System.out.println("-- NON ACTIVIATED USERS--");
displayUsers(se);
	

se.close();










	
	}

	private static void displayUsers(Session se) {

		Query query=se.createQuery("from St");
		Iterator results =query.iterate();
		while (results.hasNext()){
			St student =(St)results.next();
			System.out.println(student.getUsername() +"is");
			if(student.isActivated()){
				System.out.println("activated.");
			}
			else{
				
				System.out.println("not activated");

			}
			
			
			
			
			
			
			
		}		
	*/
/*
//to make cache
//here should do three select with three session but with cache it make once  and store in cache when seconed session or third session  wanted  get it 
//it make high performance

//load frist session and load entity
Session se =NewHibernateUtil.getSessionFactory().openSession();
Employee em =(Employee) se.load(Employee.class, 1);
System.out.println(em.getId()+" "+em.getName()+" "+em.getSalary());
se.close();

//load seconed session and load entity

Session se2 =NewHibernateUtil.getSessionFactory().openSession();
Employee em2 =(Employee) se2.load(Employee.class, 1);
System.out.println(em2.getId()+" "+em2.getName()+" "+em2.getSalary());
se2.close();

//load third session and load entity

Session se3 =NewHibernateUtil.getSessionFactory().openSession();
Employee em3 =(Employee) se3.load(Employee.class, 1);
System.out.println(em3.getId()+" "+em3.getName()+" "+em3.getSalary());
se3.close();








*/

	}
	

	}


