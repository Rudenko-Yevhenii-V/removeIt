package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.service.Shape;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.example.testtask.shape.util.ShapeUtil.getRoundedDouble;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Service("square")
public class SquareServiceImpl implements Shape {

    double side;

    @Override
    public double calculateArea() {
        return getRoundedDouble(side * side);
    }

    @Override
    public double calculatePerimeter() {
        return getRoundedDouble(4 * side);
    }

    @Override
    public void configure(ShapeRequestDto request) {
        this.side = request.getSideA();
    }
}



