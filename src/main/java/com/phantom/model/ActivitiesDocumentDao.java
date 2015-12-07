package com.phantom.model;

import com.phantom.entity.ActivitiesDocument;

import java.util.List;

/**
 * Created by vishal on 30/11/15.
 */
public interface ActivitiesDocumentDao {

    public List<ActivitiesDocument> fetchAllDocuments();

    public List<ActivitiesDocument> fetchActivitiesBasedOnCategory(String category_name);

    public List<ActivitiesDocument> getDocumentBasedOnSearch(ActivitiesDocument activitiesDocument);

}
