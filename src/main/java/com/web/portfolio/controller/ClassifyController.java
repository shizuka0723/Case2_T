package com.web.portfolio.controller;

import com.web.portfolio.entity.Classify;
import com.web.portfolio.entity.Investor;
import com.web.portfolio.service.PortfolioService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/classify")
public class ClassifyController {
    @Autowired
    private PortfolioService service;
    
    @GetMapping(value = {"/","/query"})
    public Iterable<Classify> query(){
        return service.getClassifyRepository().findAll();
    }
    
    @PostMapping(value = {"/", "/add"})
    @Transactional
    public Classify add(@RequestBody Map<String, String> map) {
        Classify classify = new Classify();
        classify.setName(map.get("name"));
        if(map.get("transaction") == null){
            classify.setTransaction(Boolean.FALSE);
        }else{
            classify.setTransaction(Boolean.TRUE);
        }
        service.getClassifyRepository().save(classify);
        return classify;
    }
    
    @GetMapping(value = {"/{id}","/get/{id}"})
    @Transactional
    public Classify get(@PathVariable("id") Long id){
        return service.getClassifyRepository().findOne(id);
    }
    
    @PutMapping(value = {"/{id}", "/update/{id}"})
    @Transactional
    public Boolean update(@PathVariable("id") Long id, @RequestBody Map<String, String> map) {
        Classify o_clClassify = get(id);
        if (o_clClassify == null) {
            return false;
        }
        Boolean check ;
        if(map.get("transaction") == null){
            check = Boolean.FALSE;
        }else{
            check = Boolean.TRUE;
        }
        service.getClassifyRepository().update(id,map.get("name") ,check);
        return true;
    }
    
    @DeleteMapping(value = {"/{id}","/delete/{id}"})
    @Transactional
    public Boolean delete(@PathVariable("id") Long id){
        service.getClassifyRepository().delete(id);
        return true;
    }
}
