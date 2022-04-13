package com.fruits.congtyhoaqua.repositories;

import com.fruits.congtyhoaqua.models.BillDetail;
import com.fruits.congtyhoaqua.models.id.BillDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailId> {

}
