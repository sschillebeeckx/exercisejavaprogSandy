package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyAlreadyExistsException;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileCompanyRepositoryTest {

    CompanyRepository cr= new FileCompanyRepository();

   /* @BeforeEach
    void setUp(){
        cr = new FileCompanyRepository();
    }*/

    @Test
    void totalCompaniesInFileIs5(){
        assertEquals(5,cr.getCompanies().size());
    }

    @Test
    void company1IsAbis() throws CompanyNotFoundException {
        assertEquals("Abis",cr.findCompany(1).getName());
    }

    @Test
    void company10ThrowsException() throws CompanyNotFoundException {
        assertThrows(CompanyNotFoundException.class,()->cr.findCompany(10));
    }

    @Test
    void companySmalsIsInList() throws CompanyNotFoundException {
        assertNotNull(cr.findCompany("smals"));
    }

    @Test
    void companySmilsIsNotInList() throws CompanyNotFoundException {
        assertThrows(CompanyNotFoundException.class,()->cr.findCompany("smils"));
    }

     @Test
    void addCompanyWorks() throws CompanyAlreadyExistsException, CompanyNotFoundException {
        cr.addCompany(new Company("new company"));
        Company c = cr.findCompany("new company");
        assertNotNull(c);
        cr.deleteCompany(c.getCompanyNumber());
     }

    @Test
    void addExistingCompanyThrowsException() throws CompanyNotFoundException {
        assertThrows(CompanyAlreadyExistsException.class,()->cr.addCompany(new Company("abis")));
    }

    @Test
    void updateAbisToSiba() throws CompanyAlreadyExistsException, CompanyNotFoundException {
       Company c = cr.findCompany(1);
       c.setName("Siba");
       cr.updateCompany(c);
       assertEquals("Siba",cr.findCompany(1).getName());
       c.setName("Abis");
       cr.updateCompany(c);
    }

    @Test
    void updateCompanyThatDoesntExist() throws CompanyAlreadyExistsException, CompanyNotFoundException {
       assertThrows(CompanyNotFoundException.class,()-> cr.updateCompany(new Company("test123")));

    }


    @Test
    void deleteNewCompany() throws CompanyAlreadyExistsException, CompanyNotFoundException {
        cr.addCompany(new Company("some"));
        cr.deleteCompany(cr.findCompany("some").getCompanyNumber());
        assertEquals(5,cr.getCompanies().size());

    }

    @Test
    void deleteAbis() throws CompanyAlreadyExistsException, CompanyNotFoundException, IOException {
        cr.deleteCompany(cr.findCompany("Abis").getCompanyNumber());
        assertEquals(4,cr.getCompanies().size());
        Company abis = new Company("Abis");
        abis.setCompanyNumber(1);
        cr.addCompany(abis);
        ((FileCompanyRepository)cr).writeAllCompanies();
    }









}
