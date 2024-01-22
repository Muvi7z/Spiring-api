package com.example.spirngapi.Product;

import com.example.spirngapi.Controller.Controller;
import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;
import com.example.spirngapi.Repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.util.LangUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;


    @MockBean
    private ProductRepository productRepository;


@Autowired
    private MockMvc mockMvc;

    @Autowired
private ObjectMapper objectMapper;



    @Test
    void getProduct() throws Exception {
        mockMvc.perform(get("/api/product/1")).andExpect(status().isOk());
    }

}
