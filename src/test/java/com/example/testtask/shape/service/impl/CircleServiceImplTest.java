package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CircleServiceImplTest {

    private CircleServiceImpl circleService;

    @BeforeEach
    void setUp() {
        circleService = new CircleServiceImpl();
    }

    @Test
    void testCalculateArea() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setRadius(10.0);
        circleService.configure(request);

        // Act
        double area = circleService.calculateArea();

        // Assert
        assertThat(area).isEqualTo(314.16);
    }

    @Test
    void testCalculatePerimeter() {
        // Arrange
        ShapeRequestDto request = new ShapeRequestDto();
        request.setRadius(10.0);
        circleService.configure(request);

        // Act
        double perimeter = circleService.calculatePerimeter();

        // Assert
        assertThat(perimeter).isEqualTo(62.83);
    }

}
