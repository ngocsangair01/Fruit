package com.fruits.congtyhoaqua.controllers;

import com.fruits.congtyhoaqua.bases.BaseController;
import com.fruits.congtyhoaqua.bases.BaseEntity;
import com.fruits.congtyhoaqua.dtos.FruitDTO;
import com.fruits.congtyhoaqua.models.Fruit;
import com.fruits.congtyhoaqua.services.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/fruits")
@CrossOrigin(origins = "*")
public class FruitController extends BaseController<Fruit> {
    @Autowired
    private IFruitService fruitService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllFruit(){
        return this.resSetSuccess(fruitService.getAllFruits());
    }

    @PostMapping("/{idManufacture}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> createFruit(@PathVariable(name = "idManufacture")Integer idManufacture,
                                         @RequestBody FruitDTO fruitDTO){
        return this.resSuccess(fruitService.createFruit(idManufacture, fruitDTO));
    }

    @PatchMapping("/{idFruit}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> editFruit(@PathVariable(name = "idFruit")Integer idFruit,@RequestBody FruitDTO fruitDTO){
        return this.resSuccess(fruitService.editFruit(idFruit, fruitDTO));
    }
    @DeleteMapping("/{idFruit}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> deleteFruit(@PathVariable(name = "idFruit")Integer idFruit){
        return this.resSuccess(fruitService.deleteFruit(idFruit));
    }
    @GetMapping("/{idFruit}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getFruitById(@PathVariable(name = "idFruit")Integer idFruit){
        return this.resSuccess(fruitService.getById(idFruit));
    }
    @GetMapping("/price")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllByPrice(@RequestParam Integer greaterPrice,
                                           @RequestParam Integer lessThanPrice){
        return this.resSetSuccess(fruitService.getAllByPrice(greaterPrice, lessThanPrice));
    }
    @GetMapping("/{idManufacture}/get-all")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllByManufacture(@PathVariable(name = "idManufacture")Integer idManufacture){
        return this.resSetSuccess(fruitService.getAllByManufacture(idManufacture));
    }
    @GetMapping("/name")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllByName(@RequestParam String name){
        return this.resSetSuccess(fruitService.getAllByName(name));
    }
    @GetMapping("/{idCategory}/getFruit")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllByCategory(@PathVariable(name = "idCategory")Integer idCategory){
        return this.resSetSuccess(fruitService.getAllFruitByCategory(idCategory));
    }

    @GetMapping("/days")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> getAllByDate(@RequestParam String afterDate,
                                          @RequestParam String beforeDate){
        return this.resSetSuccess(fruitService.getAllByDay(afterDate, beforeDate));
    }

    @PatchMapping("/{idFruit}/avatar")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> editAvatarFruit(@PathVariable(name = "idFruit")Integer idFruit,
                                             @RequestParam MultipartFile avatar){
        return this.resSuccess(fruitService.editAvatarFruit(idFruit, avatar));
    }
}
