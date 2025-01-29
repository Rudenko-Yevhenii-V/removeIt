package com.example.testtask.shape.controller;

import com.example.testtask.shape.controller.facade.ShapeFacade;
import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.model.dto.ShapeResponseDto;
import com.example.testtask.shape.model.enums.ShapeType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShapeController.class)
class ShapeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShapeFacade shapeFacade;

    @Autowired
    private ObjectMapper objectMapper;

    private ShapeRequestDto requestDto;
    private ShapeResponseDto responseDto;

    @BeforeEach
    void setUp() {
        responseDto = new ShapeResponseDto();
    }

    @Test
    void testCalculateShape_Circle() throws Exception {
        requestDto = new ShapeRequestDto();
        requestDto.setShapeType(ShapeType.CIRCLE);
        requestDto.setRadius(10.0);

        responseDto.setArea(314.159);
        responseDto.setPerimeter(62.831);

        Mockito.when(shapeFacade.calculateShape(any(ShapeRequestDto.class)))
                .thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/public/shape/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.area").value(314.159))
                .andExpect(jsonPath("$.perimeter").value(62.831));
    }

    @Test
    void testCalculateShape_Square() throws Exception {
        requestDto = new ShapeRequestDto();
        requestDto.setShapeType(ShapeType.SQUARE);
        requestDto.setSideA(5.0);

        responseDto.setArea(25.0);
        responseDto.setPerimeter(20.0);

        Mockito.when(shapeFacade.calculateShape(any(ShapeRequestDto.class)))
                .thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/public/shape/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(25.0))
                .andExpect(jsonPath("$.perimeter").value(20.0));
    }

    @Test
    void testCalculateShape_Rectangle() throws Exception {
        requestDto = new ShapeRequestDto();
        requestDto.setShapeType(ShapeType.RECTANGLE);
        requestDto.setSideA(4.0);
        requestDto.setSideB(6.0);

        responseDto.setArea(24.0);
        responseDto.setPerimeter(20.0);

        Mockito.when(shapeFacade.calculateShape(any(ShapeRequestDto.class)))
                .thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/public/shape/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(24.0))
                .andExpect(jsonPath("$.perimeter").value(20.0));
    }

    @Test
    void testCalculateShape_Triangle() throws Exception {
        requestDto = new ShapeRequestDto();
        requestDto.setShapeType(ShapeType.TRIANGLE);
        requestDto.setSideA(3.0);
        requestDto.setSideB(4.0);
        requestDto.setSideC(5.0);

        responseDto.setArea(6.0);  // Heron's formula for 3-4-5 right triangle
        responseDto.setPerimeter(12.0);

        Mockito.when(shapeFacade.calculateShape(any(ShapeRequestDto.class)))
                .thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/public/shape/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(6.0))
                .andExpect(jsonPath("$.perimeter").value(12.0));
    }

    @Test
    void testCalculateShape_InvalidRequest() throws Exception {
        ShapeRequestDto invalidRequest = new ShapeRequestDto(); // Missing shapeType

        mockMvc.perform(post("/api/v1/public/shape/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest()); // Expect 400 Bad Request
    }
}