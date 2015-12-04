package com.phantom.model.storage;

import com.phantom.entity.ActivitiesDocument;
import com.phantom.model.ActivitiesDocumentDao;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vishal on 30/11/15.
 */

@Component
public class ActivitiesDocumentDaoImpl implements ActivitiesDocumentDao {

    // connect to your solr server
    SolrServer server = new HttpSolrServer("http://localhost:8983/solr/");


    @Override
    public List<ActivitiesDocument> fetchAllDocuments() {
        return null;
    }

    @Override
    public List<ActivitiesDocument> fetchActivitiesBasedOnCategory(String category_name) {
        return null;
    }

    @Override
    public List<ActivitiesDocument> fetchAllActivitiesBasedOnSearch(String ngram) {
        return null;
    }

    @Override
    public ActivitiesDocument getDocumentBasedOnSearch(ActivitiesDocument activitiesDocument) {
        return null;
    }
}
