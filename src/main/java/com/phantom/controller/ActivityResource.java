package com.phantom.controller;

import com.phantom.entity.ActivitiesDocument;
import com.phantom.model.ActivitiesDocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by vishal on 7/12/15.
 */
@RequestMapping(value="/gimme5")
@RestController
public class ActivityResource {

    @Autowired
    private ActivitiesDocumentDao activitiesDocumentDao;


    @RequestMapping(value="/search{category}" ,method= RequestMethod.GET, produces={"application/json"})
    public List<ActivitiesDocument> searchReasults(@QueryParam("category") String category) {
        if(null==category){
            return activitiesDocumentDao.fetchAllDocuments();
        }else{
            return activitiesDocumentDao.fetchActivitiesBasedOnCategory(category);
        }
    }

    @RequestMapping(value="/search{location}" ,method= RequestMethod.GET, produces={"application/json"})
    public List<String> getLocations(@QueryParam("location")String location){
        return activitiesDocumentDao.fetchLocations(location);
    }



}
