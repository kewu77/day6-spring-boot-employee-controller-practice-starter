package com.oocl.springbootemployee;

import com.oocl.springbootemployee.Entity.Company;
import com.oocl.springbootemployee.repository.CompanyRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureJsonTesters
public class CompanyControllerTest {
    @Resource
    private CompanyRepository companyRepository;
    @Resource
    private MockMvc client;
    @Resource
    private JacksonTester<List<Company>> jacksonList;

    @Test
    public void should_return_all_companies_when_get_all_company_given_exist() throws Exception {
        //Given
        List<Company> companies = companyRepository.getAll();
        //When
        String response = client.perform(MockMvcRequestBuilders.get("/company/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andReturn().getResponse().getContentAsString();
        //Then
        List<Company> result = jacksonList.parseObject(response);
        assertThat(result).usingRecursiveComparison().isEqualTo(companies);
    }
}
