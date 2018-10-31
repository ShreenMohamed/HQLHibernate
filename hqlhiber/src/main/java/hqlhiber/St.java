package hqlhiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
//filter like view get data with specific condition
/*to create filter:
 * activated is name of variable in class "private boolean activated;"
 * condition :be parameter which accept activated(condition=":name of ParamDef =activated")
 * @Filter(name="any name" ,condition=":name of ParamDef =activated")
 @FilterDef contain name of filter which  make in it a condition
 @ParamDef any name equal name of condition
 @FilterDef(name="same name of filter",
parameters={@ParamDef(name="activatedParam",type="boolean")})
*/
@Filter(name="activatedFilter" ,condition=":activatedParam =activated")
@FilterDef(name="activatedFilter",
parameters={@ParamDef(name="activatedParam",type="boolean")})
@Entity
public class St {


	private int id;
	private String username;
    private boolean activated;
    
    
    
	public St() {
	}
	
	
	
	public St(String username, boolean activated) {
		
		this.username = username;
		this.activated = activated;
	}


@Id
@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	
	
    
    
    
	
}
