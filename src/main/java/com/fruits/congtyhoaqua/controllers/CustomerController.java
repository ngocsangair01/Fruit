package com.fruits.congtyhoaqua.controllers;

import com.fruits.congtyhoaqua.bases.BaseController;
import com.fruits.congtyhoaqua.dtos.CategoryDTO;
import com.fruits.congtyhoaqua.dtos.CustomerDTO;
import com.fruits.congtyhoaqua.models.Customer;
import com.fruits.congtyhoaqua.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController<Customer> {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO){
        return this.resSuccess(customerService.createCustomer(customerDTO));
    }

    @PatchMapping("/edit-customer/{idCustomer}")
    public ResponseEntity<?> editCustomer(@PathVariable Integer idCustomer, @RequestBody CustomerDTO customerDTO){
        return  this.resSuccess(customerService.editCustomer(idCustomer, customerDTO));
    }

    @DeleteMapping("delete-customer/{idCustomer}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer idCustomer){
        return this.resSuccess(customerService.deleteCustomer(idCustomer));
    }

    @GetMapping("/get-all-customer")
    public ResponseEntity<?> getAllCustomer(){
        return  this.resSetSuccess(customerService.getAllCustomer());
    }

}
