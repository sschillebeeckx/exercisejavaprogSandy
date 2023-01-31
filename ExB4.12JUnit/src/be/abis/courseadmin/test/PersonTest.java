package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    Person p;

    @BeforeEach
    void setUp(){
        p=new Person("Sandy","Schillebeeckx", Gender.FEMALE);
    }

    @Test
    void numberOfHobbiesAddedIs4(){
        p.addHobby("ju jutsu");
        p.addHobbies("yoga","ski","cooking");
        String[] hobbies = p.getHobbies();
        int count=0;
        for (String hobby : hobbies){
            if (hobby!=null){
                count++;
            } else {
                break;
            }
        }
        assertEquals(4,count);
    }
}
