package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RectangleServiceImplTest {

    private RectangleServiceImpl rectangleService;

    @BeforeEach
    void setUp() {
        rectangleService = new RectangleServiceImpl();
    }

    @Test
    void testCalculateArea() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(4.0);
        request.setSideB(6.0);
        rectangleService.configure(request);

        // Act
        double area = rectangleService.calculateArea();

        // Assert
        assertThat(area).isEqualTo(24.0);
    }

    @Test
    void testCalculatePerimeter() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setSideA(4.0);
        request.setSideB(6.0);
        rectangleService.configure(request);

        // Act
        double perimeter = rectangleService.calculatePerimeter();

        // Assert
        assertThat(perimeter).isEqualTo(20.0);
    }
}