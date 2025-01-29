package com.example.testtask.shape.model.dto;

import com.example.testtask.shape.model.enums.ShapeType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
public class ShapeRequestDto {

    @NotNull(message = "Shape type is required")
    ShapeType shapeType;

    @Min(value = 0, message = "Value must be positive")
    Double radius;

    @Min(value = 0, message = "Value must be positive")
    Double sideA;

    @Min(value = 0, message = "Value must be positive")
    Double sideB;

    @Min(value = 0, message = "Value must be positive")
    Double sideC;
}

