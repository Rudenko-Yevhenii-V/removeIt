package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TriangleServiceImplTest {

    private TriangleServiceImpl triangleService;

    @BeforeEach
    void setUp() {
        triangleService = new TriangleServiceImpl();
    }

    @Test
    void testCalculateArea_ValidTriangle() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(3.0);
        request.setSideB(4.0);
        request.setSideC(5.0);
        triangleService.configure(request);

        // Act
        double area = triangleService.calculateArea();

        // Assert
        assertThat(area).isEqualTo(6.0);
    }

    @Test
    void testCalculatePerimeter() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(3.0);
        request.setSideB(4.0);
        request.setSideC(5.0);
        triangleService.configure(request);

        // Act
        double perimeter = triangleService.calculatePerimeter();

        // Assert
        assertThat(perimeter).isEqualTo(12.0);
    }

}