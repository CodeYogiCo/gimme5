package com.phantom.model.storage;

import com.phantom.entity.ActivitiesDocument;
import com.phantom.model.ActivitiesDocumentDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 30/11/15.
 */

@Component
public class ActivitiesDocumentDaoImpl implements ActivitiesDocumentDao {

    // connect to your solr server
    @Autowired
    private SolrServer solr;


    @Override
    public List<ActivitiesDocument> fetchAllDocuments() {
        System.out.println("Inside fetchDoscuments");
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        QueryResponse response = null;
        try {
            response = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        List<ActivitiesDocument> activitiesDocumentList  = new ArrayList<>();
        SolrDocumentList docList = (SolrDocumentList) response.getResults();

        for (int i = 0; i < docList.size(); i++) {

            ActivitiesDocument activitiesDocument = new ActivitiesDocument();

            activitiesDocument.setId(docList.get(i).getFieldValue("id").toString());

            activitiesDocument.setEntry_name(docList.get(i).getFieldValue("entry_name").toString());

            activitiesDocument.setCategory_name(docList.get(i).getFieldValue("category_name").toString());

            activitiesDocument.setLocation_name(docList.get(i).getFieldValue("location_name").toString());

            activitiesDocument.setSpeciality_name(docList.get(i).getFieldValue("speciality_name").toString());

            activitiesDocumentList.add(activitiesDocument);

        }
        return activitiesDocumentList;
    }

    @Override
    public List<ActivitiesDocument> fetchActivitiesBasedOnCategory(String category_name) {
        SolrQuery query = new SolrQuery();
        query.setQuery("category_name:"+category_name.toLowerCase());
        QueryResponse response = null;
        try {
            response = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        List<ActivitiesDocument> activitiesDocumentList  = new ArrayList<>();
        SolrDocumentList docList = (SolrDocumentList) response.getResults();


        for (int i = 0; i < docList.size(); i++) {

            ActivitiesDocument activitiesDocument = new ActivitiesDocument();

            activitiesDocument.setId(docList.get(i).getFieldValue("id").toString());

            activitiesDocument.setEntry_name(docList.get(i).getFieldValue("entry_name").toString());

            activitiesDocument.setCategory_name(docList.get(i).getFieldValue("category_name").toString());

            activitiesDocument.setLocation_name(docList.get(i).getFieldValue("location_name").toString());

            activitiesDocument.setSpeciality_name(docList.get(i).getFieldValue("speciality_name").toString());

            activitiesDocumentList.add(activitiesDocument);

        }
        return activitiesDocumentList;
    }


    @Override
    public List<String> fetchLocations(String location_name) {
        SolrQuery query = new SolrQuery();
        query.setQuery("location_name:"+location_name.toLowerCase());
        query.setParam("wt", "json");

        System.out.println("the query is ++++++++++++ "+query);
        QueryResponse response = null;
        try {
            response = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        List<String> activitiesDocumentList  = new ArrayList<>();
        SolrDocumentList docList = (SolrDocumentList) response.getResults();


        for (int i = 0; i < docList.size(); i++) {

            activitiesDocumentList.add(docList.get(i).getFieldValue("location_name").toString());

        }
        return activitiesDocumentList;
    }

//    @Override
//    public List<ActivitiesDocument> getDocumentBasedOnSearch(ActivitiesDocument activitiesDocument) {
//        String category_name  = activitiesDocument.getCategory_name();
//        String entry_name = activitiesDocument.getEntry_name();
//        String location_name = activitiesDocument.getLocation_name();
//        String speciality_name = activitiesDocument.getSpeciality_name();
//        SolrQuery query = new SolrQuery();
//        query.setQuery("entry_name:"+entry_name);
//        query.setFilterQueries("category_name="+category_name,"location_name="+location_name,"speciality_name="+speciality_name);
//        QueryResponse response = null;
//        try {
//            response = solr.query(query);
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        }
//        List<ActivitiesDocument> activitiesDocumentList  = new ArrayList<>();
//        SolrDocumentList docList = (SolrDocumentList) response.getResults();
//
//
//        for (int i = 0; i < docList.size(); i++) {
//
//            ActivitiesDocument newactivitiesDocument = new ActivitiesDocument();
//
//            newactivitiesDocument.setId(docList.get(i).getFieldValue("id").toString());
//
//            newactivitiesDocument.setEntry_name(docList.get(i).getFieldValue("entry_name").toString());
//
//            newactivitiesDocument.setCategory_name(docList.get(i).getFieldValue("category_name").toString());
//
//            newactivitiesDocument.setLocation_name(docList.get(i).getFieldValue("location_name").toString());
//
//            newactivitiesDocument.setSpeciality_name(docList.get(i).getFieldValue("speciality_name").toString());
//
//            activitiesDocumentList.add(newactivitiesDocument);
//
//        }
//        return activitiesDocumentList;
//    }



}
