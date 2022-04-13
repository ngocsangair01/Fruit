package com.fruits.congtyhoaqua.controllers;

import com.fruits.congtyhoaqua.bases.BaseController;
import com.fruits.congtyhoaqua.dtos.BillDetailDTO;
import com.fruits.congtyhoaqua.models.Bill;
import com.fruits.congtyhoaqua.services.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bill-details")
public class BillController extends BaseController<Bill> {
    @Autowired
    private IBillService billService;

    @PostMapping("/{idUser}/{idCustomer}")
    public ResponseEntity<?> createBill(@PathVariable(name = "idUser") Integer idUser,
                                        @PathVariable(name = "idCustomer")Integer idCustomer,
                                        @RequestBody Set<BillDetailDTO> billDetailDTOS){
        return this.resSuccess(billService.createBill(idUser, idCustomer,billDetailDTOS));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<?> getAllBillByIdUser(@PathVariable(name = "idUser")Integer idUser){
        return this.resSetSuccess(billService.getAllBillByIdUser(idUser));
    }

    @GetMapping("/{idBill}/detail")
    public ResponseEntity<?> getBillById(@PathVariable(name = "idBill")Integer idBill){
        return this.resSuccess(billService.getBillById(idBill));
    }
    @GetMapping("/date")
    public ResponseEntity<?> filterByTime(@RequestParam String start,
                                          @RequestParam String end){
        return this.resSetSuccess(billService.filterByTime(start,end));
    }

    @PostMapping
    public ResponseEntity<?> getAllBill(){
        return this.resSetSuccess(billService.getAllBill());
    }
}
