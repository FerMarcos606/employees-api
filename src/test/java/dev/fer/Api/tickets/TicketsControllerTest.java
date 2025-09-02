package dev.fer.Api.tickets;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;

@WebMvcTest(TicketsController.class) 
@TestPropertySource(properties = "api-endpoint=/api/v1")
public class TicketsControllerTest {

      @Autowired
    private MockMvc mockMvc;

    
    @Autowired
    ObjectMapper mapper;

   @MockitoBean
    private TicketsService service;

     @Test
        void testIndex_ShouldReturnAName() throws Exception {
            TicketsEntity LuisR = new TicketsEntity();
            LuisR.setId(1L);
            LuisR.setEmployeesName("JuanP");
            LuisR.setDescription("El tema del ticket ha desaparecido");
            List<TicketsEntity> lista = Arrays.asList(LuisR);
            when(service.getTickets()).thenReturn(lista);
            String json = mapper.writeValueAsString(lista);

            
            MockHttpServletResponse response = mockMvc.perform(get("/api/v1/tickets"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

            assertThat(response.getStatus(), is(equalTo(200)));
            assertThat(response.getContentAsString(), is(equalTo(json)));
        }

             @Test
            void testStoreTickets_ShouldReturnCreated() throws Exception {
            TicketsEntity ticket = new TicketsEntity();
            ticket.setEmployeesName("DanielH");
            ticket.setSubject("Falta email");
            ticket.setDescription("En el ticket no se encuentra el email del usuario");

            String json = mapper.writeValueAsString(ticket);

            when(service.saveTickets(any(TicketsEntity.class))).thenReturn(ticket);

            mockMvc.perform(post("/api/v1/tickets")
                            .content(json)
                            .contentType("application/json"))
                    .andExpect(status().isCreated());
        }

            @Test
            void testGetTicketById_ShouldReturnTicket() throws Exception {
            // 1. Crear el ticket simulado
            TicketsEntity ticket = new TicketsEntity();
            ticket.setId(1L);
            ticket.setEmployeesName("JuanP");
            ticket.setDescription("El tema del ticket ha desaparecido");

            // 2. Simular el service
            when(service.getTicketById(1L)).thenReturn(ticket);

            // 3. Convertir a JSON para comparar
            String json = mapper.writeValueAsString(ticket);

            // 4. Ejecutar la petición GET y validar
            MockHttpServletResponse response = mockMvc.perform(get("/api/v1/tickets/1"))
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse();

            // 5. Comprobar que la respuesta es correcta
            assertThat(response.getContentAsString(), is(equalTo(json)));
        }

    
    
    
    }





