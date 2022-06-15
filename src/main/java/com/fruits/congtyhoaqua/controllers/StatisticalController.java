package com.fruits.congtyhoaqua.controllers;

import com.fruits.congtyhoaqua.bases.BaseController;
import com.fruits.congtyhoaqua.models.Bill;
import com.fruits.congtyhoaqua.services.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistical")
public class StatisticalController {
    @Autowired
    private IStatisticalService statisticalService;

    @GetMapping("")
    public ResponseEntity<?> revenueForTheYear(){
        return ResponseEntity.status(200).body(statisticalService.RevenueForTheYear());
    }
}
