package com.web.portfolio.dao;

import com.web.portfolio.entity.Classify;
import com.web.portfolio.entity.TStock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "tStockRepository")
public interface TStockRepository extends CrudRepository<TStock, Long>{
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE TStock SET name=?2, symbol=?3 ,classify_id = ?4 WHERE id=?1")
    public void update(Long id, String name, String symbol,Long classify_id);
}