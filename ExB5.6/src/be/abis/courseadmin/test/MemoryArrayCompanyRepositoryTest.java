package be.abis.courseadmin.test;


import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryArrayCompanyRepositoryTest {

    CompanyRepository cr ;

    @BeforeEach
    public void setUp(){
        cr = new MemoryArrayCompanyRepository();
    }

    @Test
    public void company1IsAbis() throws CompanyNotFoundException {
       Company c= cr.findCompany(1);
       assertEquals("ABIS" , c.getName());
    }

    @Test
    public void company10ThrowsCompanyNotFoundException()  {
        assertThrows(CompanyNotFoundException.class, ()->cr.findCompany(10));
    }




}
