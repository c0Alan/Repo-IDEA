package com.demo.springcloud.es.controller;

import com.demo.springcloud.es.entity.BusReceiverEntity;
import com.demo.springcloud.es.service.BusReceiverService;
import com.demo.springcloud.es.utils.NameBuildUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    BusReceiverService busReceiverService;

    @RequestMapping("/save")
    public String save(){
        busReceiverService.save(NameBuildUtils.buildReceiver());
        return "save";
    }

    @RequestMapping("/batchSave/{count}")
    public String save(@PathVariable  int count){
        Long startTime = System.currentTimeMillis();
        List<BusReceiverEntity> list = new ArrayList<BusReceiverEntity>();
        for(int i=1; i<=count; i++){
            if(i%10000 == 0){
                list.add(NameBuildUtils.buildReceiver());
                busReceiverService.saveBatch(list);
                list.clear();
            }else{
                list.add(NameBuildUtils.buildReceiver());
            }
        }
        if(list.size()>0){
            busReceiverService.saveBatch(list);
        }
        return "batchSave:"+(System.currentTimeMillis()-startTime);
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        busReceiverService.deleteAll();
        return "deleteAll";
    }

    @RequestMapping("/queryByName")
    public List<BusReceiverEntity> queryByName(@RequestParam("name") String name) {
        return busReceiverService.queryByName(name);
    }
}