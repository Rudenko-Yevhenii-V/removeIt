package com.example.testtask.shape.controller.facade;

import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.model.dto.ShapeResponseDto;

import javax.validation.Valid;

public interface ShapeFacade {

    ShapeResponseDto calculateShape(@Valid ShapeRequestDto request);

}
