package danggialoc.learn.masterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import danggialoc.learn.masterclass.demo.BeanConfig;
import danggialoc.learn.masterclass.demo.Doctor;
import danggialoc.learn.masterclass.demo.Nurse;
import danggialoc.learn.masterclass.demo.Staff;

@SpringBootApplication
public class MasterclassApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MasterclassApplication.class, args);
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
//		Doctor doctor = context.getBean(Doctor.class);
//		doctor.assist();
//		
//		Nurse nurse = (Nurse) context.getBean("nurse"); //call id từ xml
//		nurse.assist();
//		
//		Staff staff = context.getBean(Nurse.class);//call từ interface
//		staff.assist();
//		
//		Doctor doctor1 = context.getBean(Doctor.class);
//		doctor1.assist();
//		System.out.println("Qualification is " + doctor1.getQualifigcation()); // lấy value từ file xml với properties
////		System.out.println("Qualification is " + doctor1.getNurse());
		
//		Doctor doctor = context.getBean(Doctor.class);
//		doctor.assist();
//		
////		Staff staff = context.getBean(Nurse.class); // before @Component class
////		staff.assist();
//		
//		Staff staff1 = context.getBean(Doctor.class);
//		staff1.assist();
//		
//		Staff staff2 = context.getBean(Nurse.class); // After
//		staff2.assist();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Doctor doctor = context.getBean(Doctor.class);
		doctor.assist();
		doctor.setQualifigcation("MBBS");
//		System.out.println(doctor);
//
//		Doctor doctor1 = context.getBean(Doctor.class);
//		System.out.println(doctor1);
	}

}
