package com.varna.firstjobapp.company;

import com.varna.firstjobapp.company.impl.CompanyServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Long id, Company company);

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);


}
