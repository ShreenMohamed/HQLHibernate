package hqlhiber;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/* cashing is store data which i get it from database in place called cashe is better than get data from 
data base every time
exist default cache
i can make cashe with some condition
we do eh cash:
1-we should install jar ehcash &common loggin
in ehcashe jar we found hibernate then singleton ehcacheprovider which we can use 
2-edit hibernate.cfg.xml file
3- add annotation of cache
4- MAKE AFILE IN XML CALLED EHCACHE
5- edit main class
*/
//PUT DATA IN CACHE

@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

@Entity


public class Employee{


	
	private int id;
	private String name;
    private float salary;
    
    
    
    
    
    
	public Employee() {
	}
	
	
	public Employee(String name, float salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

@Id
@TableGenerator(name="d" ,allocationSize = 1)
@GeneratedValue(generator="d" ,strategy=GenerationType.TABLE)

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
    
    
	
	
}
