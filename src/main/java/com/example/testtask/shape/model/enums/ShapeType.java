package com.example.testtask.shape.model.enums;

import com.example.testtask.shape.service.Shape;
import com.example.testtask.shape.service.impl.CircleServiceImpl;
import com.example.testtask.shape.service.impl.RectangleServiceImpl;
import com.example.testtask.shape.service.impl.SquareServiceImpl;
import com.example.testtask.shape.service.impl.TriangleServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Available Shape Types")
@Getter
public enum ShapeType {
    @Schema(description = "Square shape")
    SQUARE(SquareServiceImpl.class),

    @Schema(description = "Rectangle shape")
    RECTANGLE(RectangleServiceImpl.class),

    @Schema(description = "Triangle shape")
    TRIANGLE(TriangleServiceImpl.class),

    @Schema(description = "Circle shape")
    CIRCLE(CircleServiceImpl.class);

    private final Class<? extends Shape> shapeClass;

    ShapeType(Class<? extends Shape> shapeClass) {
        this.shapeClass = shapeClass;
    }
}

