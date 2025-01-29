package com.example.testtask.shape.service.impl;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.service.Shape;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.example.testtask.shape.util.ShapeUtil.getRoundedDouble;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Service("triangle")
public class TriangleServiceImpl implements Shape {
    double sideA, sideB, sideC;

    @Override
    public double calculateArea() {
        double p = (sideA + sideB + sideC) / 2;
        return getRoundedDouble(Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)));
    }

    @Override
    public double calculatePerimeter() {
        return getRoundedDouble(sideA + sideB + sideC);
    }

    @Override
    public void configure(ShapeRequestDto request) {
        this.sideA = request.getSideA();
        this.sideB = request.getSideB();
        this.sideC = request.getSideC();
    }
}
