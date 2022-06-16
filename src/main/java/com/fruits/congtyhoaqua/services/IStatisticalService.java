package com.fruits.congtyhoaqua.services;


import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IStatisticalService {
    List<Double> RevenueForTheYear();
    Map<String, Integer> TopFiveStaffAscending(String start, String end);
    Map<String, Integer> TopFiveStaffDecrease(String start,String end);
    Map<String, Integer> TopFiveFruitBestseller(String start, String end);
    Map<String, Integer> TopFiveFruitSlowestSelling(String start, String end);
}
