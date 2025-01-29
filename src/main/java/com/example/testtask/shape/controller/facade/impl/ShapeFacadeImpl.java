package com.example.testtask.shape.controller.facade.impl;

import com.example.testtask.shape.controller.facade.ShapeFacade;
import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.model.dto.ShapeResponseDto;
import com.example.testtask.shape.service.Shape;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ShapeFacadeImpl implements ShapeFacade {

    ApplicationContext context;

    @Override
    public ShapeResponseDto calculateShape(ShapeRequestDto request) {
        Shape shape = context.getBean(request.getShapeType().getShapeClass());
        shape.configure(request);

        return ShapeResponseDto.builder()
                .area(shape.calculateArea())
                .perimeter(shape.calculatePerimeter())
                .build();
    }
}
