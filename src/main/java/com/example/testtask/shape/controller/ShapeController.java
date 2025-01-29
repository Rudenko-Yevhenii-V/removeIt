package com.example.testtask.shape.controller;

import com.example.testtask.shape.controller.facade.ShapeFacade;
import com.example.testtask.shape.model.dto.ShapeRequestDto;
import com.example.testtask.shape.model.dto.ShapeResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

@RestController
@Tag(name="Shape calculate")
@RequestMapping(value = "/api/v1/public/shape")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ShapeController {

    ShapeFacade shapeFacade;

    @PostMapping("/calculate")
    public ResponseEntity<ShapeResponseDto> calculateShape(@Valid @RequestBody ShapeRequestDto request) {
        ShapeResponseDto response = shapeFacade.calculateShape(request);

        return ResponseEntity.ok(response);
    }
}
