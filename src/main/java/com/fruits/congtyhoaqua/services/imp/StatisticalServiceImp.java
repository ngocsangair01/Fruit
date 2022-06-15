package com.fruits.congtyhoaqua.services.imp;

import com.fruits.congtyhoaqua.models.Bill;
import com.fruits.congtyhoaqua.models.BillDetail;
import com.fruits.congtyhoaqua.repositories.BillRepository;
import com.fruits.congtyhoaqua.services.IBillService;
import com.fruits.congtyhoaqua.services.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class StatisticalServiceImp implements IStatisticalService {

    @Autowired
    private IBillService billService;

    @Autowired
    private BillRepository billRepository;


    public Double RevenueForTheMonth(String start, String end){
        LocalDate startDateConvert = LocalDate.parse(start);
        LocalDate endDateConvert = LocalDate.parse(end);
        Double billPrice = 0.0;
        Double billDetailPrice = 0.0;
        Set<Bill> bills = new HashSet<>(billRepository.findAllByDateCreatedBetween(startDateConvert,endDateConvert));
        for (Bill bill : bills) {
            Set<BillDetail> billDetails = bill.getBillDetails();
            for (BillDetail billDetail : billDetails) {
                billDetailPrice = (double) (billDetail.getFruit().getPriceOut() * billDetail.getAmount());
                billPrice += billDetailPrice;
            }
        }
        return billPrice;
    }

    @Override
    public Set<Double> RevenueForTheYear() {
        Set<Double> doubles = new HashSet<>();
        Double jan = RevenueForTheMonth("2022-01-01","2022-01-31");
        Double feb = RevenueForTheMonth("2022-02-01","2022-02-29");
        Double mar = RevenueForTheMonth("2022-03-01","2022-03-31");
        Double apr = RevenueForTheMonth("2022-04-01","2022-04-30");
        Double may = RevenueForTheMonth("2022-05-01","2022-05-31");
        Double jun = RevenueForTheMonth("2022-06-01","2022-06-30");
        Double jul = RevenueForTheMonth("2022-07-01","2022-07-31");
        Double aug = RevenueForTheMonth("2022-08-01","2022-08-31");
        Double sep = RevenueForTheMonth("2022-09-01","2022-09-30");
        Double oct = RevenueForTheMonth("2022-10-01","2022-10-31");
        Double nov = RevenueForTheMonth("2022-11-01","2022-11-30");
        Double dec = RevenueForTheMonth("2022-12-01","2022-12-31");
        doubles.add(jan);
        doubles.add(feb);
        doubles.add(mar);
        doubles.add(apr);
        doubles.add(may);
        doubles.add(jun);
        doubles.add(jul);
        doubles.add(aug);
        doubles.add(sep);
        doubles.add(oct);
        doubles.add(nov);
        doubles.add(dec);
        return doubles;
    }

    @Override
    public Set<Double> TopFiveStaffAscending() {
        return null;
    }

    @Override
    public Set<Double> TopFiveStaffDecrease() {
        return null;
    }

    @Override
    public Set<Double> TopFiveFruitBestseller() {
        return null;
    }

    @Override
    public Set<Double> TopFiveFruitSlowestSelling() {
        return null;
    }
}
