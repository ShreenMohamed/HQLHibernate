package hqlhiber;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.persistence.SecondaryTable;
@Entity
@Table(name ="person")
@SecondaryTable(name = "jobs")
@NamedQuery(name="byname" ,query="from Person where name=?")
public class Person {
	
	private int id;
	private String name;
    private int salary;
	private String position;
	private String jobTitle;
	private int ver;
	
	
//version is lock means don't two person in the same time make update in column
	// version means if two session requested in the same time it excute afrist session 
	@Version
	public int getVer() {
		return ver;
	}
	public void setVer(int ver) {
		this.ver = ver;
	}
	@Id
	@TableGenerator(name="de",pkColumnName ="pk",pkColumnValue="pkv",initialValue = 1,allocationSize=1)
	@GeneratedValue(strategy =GenerationType.TABLE ,generator="de")
	@Column(name = "pk", length =225, nullable =false, unique =true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	@Column(name = "name", length =225)
	@OrderBy("name asc")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(table ="jobs")
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Column(table ="jobs")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(table ="jobs")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	
}
