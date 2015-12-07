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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 30/11/15.
 */

@Component
public class ActivitiesDocumentDaoImpl implements ActivitiesDocumentDao {

    // connect to your solr server
    SolrServer solr = new HttpSolrServer("http://localhost:8983/solr/gimme5Collection");


    @Override
    public List<ActivitiesDocument> fetchAllDocuments() {
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
        SolrDocument doc = null;

        for (int i = 0; i < docList.size(); i++) {

            ActivitiesDocument activitiesDocument = new ActivitiesDocument();

            activitiesDocument.setId(doc.getFieldValue("id").toString());

            activitiesDocument.setEntry_name(doc.getFieldValue("entry_name").toString());

            activitiesDocument.setCategory_name(doc.getFieldValue("category_name").toString());

            activitiesDocument.setLocation_name(doc.getFieldValue("location_name").toString());

            activitiesDocument.setSpeciality_name(doc.getFieldValue("speciality_name").toString());

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
        SolrDocument doc = null;

        for (int i = 0; i < docList.size(); i++) {

            ActivitiesDocument activitiesDocument = new ActivitiesDocument();

            activitiesDocument.setId(doc.getFieldValue("id").toString());

            activitiesDocument.setEntry_name(doc.getFieldValue("entry_name").toString());

            activitiesDocument.setCategory_name(doc.getFieldValue("category_name").toString());

            activitiesDocument.setLocation_name(doc.getFieldValue("location_name").toString());

            activitiesDocument.setSpeciality_name(doc.getFieldValue("speciality_name").toString());

            activitiesDocumentList.add(activitiesDocument);

        }
        return activitiesDocumentList;
    }

    @Override
    public List<ActivitiesDocument> getDocumentBasedOnSearch(ActivitiesDocument activitiesDocument) {
        String category_name  = activitiesDocument.getCategory_name();
        String entry_name = activitiesDocument.getEntry_name();
        String location_name = activitiesDocument.getLocation_name();
        String speciality_name = activitiesDocument.getSpeciality_name();
        SolrQuery query = new SolrQuery();
        query.setQuery("entry_name:"+entry_name);
        query.setFilterQueries("category_name="+category_name,"location_name="+location_name,"speciality_name="+speciality_name);
        QueryResponse response = null;
        try {
            response = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        List<ActivitiesDocument> activitiesDocumentList  = new ArrayList<>();
        SolrDocumentList docList = (SolrDocumentList) response.getResults();
        SolrDocument doc = null;

        for (int i = 0; i < docList.size(); i++) {

            ActivitiesDocument newactivitiesDocument = new ActivitiesDocument();

            newactivitiesDocument.setId(doc.getFieldValue("id").toString());

            newactivitiesDocument.setEntry_name(doc.getFieldValue("entry_name").toString());

            newactivitiesDocument.setCategory_name(doc.getFieldValue("category_name").toString());

            newactivitiesDocument.setLocation_name(doc.getFieldValue("location_name").toString());

            newactivitiesDocument.setSpeciality_name(doc.getFieldValue("speciality_name").toString());

            activitiesDocumentList.add(newactivitiesDocument);

        }
        return activitiesDocumentList;
    }
}
