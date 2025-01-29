package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.service.Shape;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.example.testtask.shape.util.ShapeUtil.getRoundedDouble;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Service("rectangle")
public class RectangleServiceImpl implements Shape {
    double length;
    double width;

    @Override
    public double calculateArea() {
        return getRoundedDouble(length * width);
    }

    @Override
    public double calculatePerimeter() {
        return getRoundedDouble(2 * (length + width));
    }

    @Override
    public void configure(ShapeRequestDto request) {
        this.length = request.getSideA();
        this.width = request.getSideB();
    }
}
