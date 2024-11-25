package com.oocl.springbootemployee;

import com.oocl.springbootemployee.Entity.Employee;
import com.oocl.springbootemployee.Entity.EmployeeRepository;
import com.oocl.springbootemployee.commmon.Gender;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureJsonTesters
class EmployeeControllerTest {

    @Resource
    private EmployeeRepository employeeRepository;
    @Resource
    private MockMvc client;
    @Resource
    private JacksonTester<Employee> jacksonTester;
    @Resource
    private JacksonTester<List<Employee>> jacksonList;

    @Test
    public void should_return_all_employees_when_get_all_employee_given_exist() throws Exception {
        //Given
        List<Employee> employees = employeeRepository.getAll();
        //When
        String response = client.perform(MockMvcRequestBuilders.get("/employee/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andReturn().getResponse().getContentAsString();
        //Then
        List<Employee> result = jacksonList.parseObject(response);
        assertThat(result).usingRecursiveComparison().isEqualTo(employees);
    }

    @Test
    public void should_an_Employee_when_get_by_id_given_an_existing_id() throws Exception {
        //Given
        Employee expectEmployee = employeeRepository.getAll().get(0);
        //When
        String response = client.perform(MockMvcRequestBuilders.get("/employee/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        //Then
        Employee result = jacksonTester.parseObject(response);
        assertEquals(expectEmployee.getId(),result.getId());
    }


}
