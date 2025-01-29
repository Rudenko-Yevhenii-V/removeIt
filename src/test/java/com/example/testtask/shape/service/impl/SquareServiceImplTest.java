package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SquareServiceImplTest {

    private SquareServiceImpl squareService;

    @BeforeEach
    void setUp() {
        squareService = new SquareServiceImpl();
    }

    @Test
    void testCalculateArea() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(5.0);
        squareService.configure(request);

        // Act
        double area = squareService.calculateArea();

        // Assert
        assertThat(area).isEqualTo(25.0);
    }

    @Test
    void testCalculatePerimeter() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(5.0);
        squareService.configure(request);

        // Act
        double perimeter = squareService.calculatePerimeter();

        // Assert
        assertThat(perimeter).isEqualTo(20.0);
    }

}