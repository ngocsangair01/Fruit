package com.fruits.congtyhoaqua.services;

import java.util.Set;

public interface IStatisticalService {
    Set<Double> RevenueForTheYear();
    Set<Double> TopFiveStaffAscending();
    Set<Double> TopFiveStaffDecrease();
    Set<Double> TopFiveFruitBestseller();
    Set<Double> TopFiveFruitSlowestSelling();
}
