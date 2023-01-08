package com.example.demo.utilities;

import java.time.LocalDate;
import java.time.Period;

public class Utility {
    // Ex. 2022-09-27
    public static int computeAgeByYear(String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        LocalDate currentDate = LocalDate.now();

        return Period.between(convertedDate, currentDate).getYears();
    }
}