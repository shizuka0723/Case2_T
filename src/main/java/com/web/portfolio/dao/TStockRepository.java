package com.web.portfolio.dao;

import com.web.portfolio.entity.TStock;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "tStockRepository")
public interface TStockRepository extends CrudRepository<TStock, Long>{
    

}