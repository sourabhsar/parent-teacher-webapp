package com.sourabh.pt.controller;

import com.mongodb.DBCollection;
import com.sourabh.pt.coremodel.TestBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Sourabh on 7/23/2016.
 */

@RestController
public class TestController {

    private TestBean bean;
    private DBCollection dbCollection;

    @Inject
    public TestController(TestBean bean,DBCollection dbCollection) {
        this.bean = bean;
        this.dbCollection = dbCollection;
    }

    @RequestMapping(value="/find",method = POST)
    public TestBean find(@RequestBody QueryInfo query) {
        System.out.println("DB Collection Accident Table Count: "+ dbCollection.count()+ " query.skip = "+query.skip);
        return bean;
    }
}
