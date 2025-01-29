package com.example.testtask.shape.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShapeResponseDto {

    @JsonProperty(value = "area", required = true)
    double area;

    @JsonProperty(value = "perimeter", required = true)
    double perimeter;

}
