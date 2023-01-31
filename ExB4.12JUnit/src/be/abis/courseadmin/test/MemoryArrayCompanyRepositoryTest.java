package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import org.junit.jupiter.api.Test;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryArrayCompanyRepositoryTest {

    CompanyRepository cr = new MemoryArrayCompanyRepository();  //arrange

    @Test
    void numberOfCompaniesIs5(){
        int result = 5;
        Company[] companies = cr.getCompanies();
        assertEquals(result,companies.length);
    }
    @Test
    void nameOfCompany1IsABIS() {
        Company c = cr.findCompany(1);   //act
        assertEquals("ABIS",c.getName());   //assert
    }

    @Test
    void numberOfCompanyTTLis4() {
        Company c = cr.findCompany("ttl");
        assertEquals(4,c.getCompanyNumber());
    }



}