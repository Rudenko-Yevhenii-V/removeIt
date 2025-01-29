package com.example.testtask.shape.service;


import com.example.testtask.shape.model.dto.ShapeRequestDto;

public interface Shape {

    double calculateArea();

    double calculatePerimeter();

    void configure(ShapeRequestDto request);

}
