package com.phantom.controller;

import com.phantom.entity.ActivitiesDocument;
import com.phantom.model.ActivitiesDocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vishal on 7/12/15.
 */
@RequestMapping(value="/gimme5")
@RestController
public class ActivityResource {

    @Autowired
    private ActivitiesDocumentDao activitiesDocumentDao;


    @RequestMapping(value="/user/searchCategory" ,method= RequestMethod.GET, produces={"application/json"})
    public List<ActivitiesDocument> searchReasults(String field) {
        if(field.isEmpty()){
            List<ActivitiesDocument> activitiesDocumentList = activitiesDocumentDao.fetchAllDocuments();
            return activitiesDocumentList;
        }else{
            return activitiesDocumentDao.fetchActivitiesBasedOnCategory(field);
        }

    }

}
