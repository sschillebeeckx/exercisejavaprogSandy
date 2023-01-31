package be.abis.demo.test;


import be.abis.demo.model.Address;
import be.abis.demo.model.Gender;
import be.abis.demo.model.Instructor;

import java.util.Date;

import static be.abis.demo.model.Instructor.setMaxYearsOfSeniority;
import static java.lang.System.*;

public class TestInstructor {

       private String someVariable;

       public static void main(String[] args) {

              Address a = new Address("diestsevest","32 bus 4b","Leuven");

              Instructor inst1 = new Instructor("Sandy", Gender.FEMALE,42,4000.0);
              inst1.setStartAge(27);
              inst1.setMonthlyGrossSalary(4500.0);
              inst1.setAddress(a);
              Instructor inst2 = new Instructor("Arnout",Gender.MALE,37,4600);

              inst2.teach("Python");
             // String[] subjects = {"java","oracle"};
              inst1.teach( new String[]{"java","oracle"});
              inst1.teach("java","oracle","lmqksdjf","mqlkdf");

              inst1.calculateNetSalary();

              setMaxYearsOfSeniority(30);

              Math.pow(3,5);
              Date d = new Date();
       }


       public  void doSomething(){
              out.println("blabla");
       }
}
