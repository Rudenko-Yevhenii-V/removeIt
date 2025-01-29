package com.example.testtask.shape.model.enums;

import com.example.testtask.shape.service.Shape;
import com.example.testtask.shape.service.impl.CircleServiceImpl;
import com.example.testtask.shape.service.impl.RectangleServiceImpl;
import com.example.testtask.shape.service.impl.SquareServiceImpl;
import com.example.testtask.shape.service.impl.TriangleServiceImpl;
import lombok.Getter;

@Getter
public enum ShapeType {
    SQUARE(SquareServiceImpl.class),
    RECTANGLE(RectangleServiceImpl.class),
    TRIANGLE(TriangleServiceImpl.class),
    CIRCLE(CircleServiceImpl.class);

    private final Class<? extends Shape> shapeClass;

    ShapeType(Class<? extends Shape> shapeClass) {
        this.shapeClass = shapeClass;
    }

}

