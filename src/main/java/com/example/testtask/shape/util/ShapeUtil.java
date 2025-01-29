package com.example.testtask.shape.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ShapeUtil {

    public static double getRoundedDouble(Double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
