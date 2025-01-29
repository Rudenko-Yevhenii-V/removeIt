package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.service.Shape;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.example.testtask.shape.util.ShapeUtil.getRoundedDouble;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Service("circle")
public class CircleServiceImpl implements Shape {

    double radius;

    @Override
    public double calculateArea() {
        return getRoundedDouble(Math.PI * radius * radius);
    }

    @Override
    public double calculatePerimeter() {
        return getRoundedDouble(2 * Math.PI * radius);
    }

    @Override
    public void configure(ShapeRequestDto request) {
        this.radius = request.getRadius();
    }
}


