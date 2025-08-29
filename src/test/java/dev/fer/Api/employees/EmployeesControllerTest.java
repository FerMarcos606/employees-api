package dev.fer.Api.employees;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;

    @WebMvcTest(controllers = EmployeesController.class)
    public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
    @Autowired
    ObjectMapper mapper;

   @MockitoBean
    private EmployeesService service;


        
        @Test
        void testIndex_ShouldReturnAName() throws Exception {
            EmployeesEntity LuisR = new EmployeesEntity(1L, "JuanP");
            List<EmployeesEntity> lista = Arrays.asList(LuisR);
            when(service.getEmployees()).thenReturn(lista);
            String json = mapper.writeValueAsString(lista);

            
            MockHttpServletResponse response = mockMvc.perform(get("/api/v1/employees"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

            assertThat(response.getStatus(), is(equalTo(200)));
            assertThat(response.getContentAsString(), is(equalTo(json)));
        }
    }

