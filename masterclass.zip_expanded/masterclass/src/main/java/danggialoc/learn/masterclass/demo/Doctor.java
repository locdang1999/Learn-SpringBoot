package danggialoc.learn.masterclass.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = "prototype") // default singleton
@Component
public class Doctor implements Staff, BeanNameAware{

		@Override
	public String toString() {
		return "Doctor [qualifigcation=" + qualifigcation + "]";
	}
	
	private String qualifigcation;
	
//	private Nurse nurse;
	
//	public Nurse getNurse() {
//		return nurse;
//	}
//
//	public void setNurse(Nurse nurse) {
//		this.nurse = nurse;
//	}

//	public Doctor(String qualifigcation) {
//		super();
//		this.qualifigcation = qualifigcation;
//	}

	public String getQualifigcation() {
		return qualifigcation;
	}

	public void setQualifigcation(String qualifigcation) {
		this.qualifigcation = qualifigcation;
	}

	public void assist() {
		System.out.println("Doctor is assisting");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Set bean name method is called");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Post Construct Method is called");
	}

}
