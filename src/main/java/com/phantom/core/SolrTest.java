package com.phantom.core;

import com.phantom.entity.ActivitiesDocument;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 30/11/15.
 */
public class SolrTest {

    public static void main(String[] args) {
        String server  = "http://localhost:8983/solr/";
        String collectionName = "/gimme5Collection/";
        String getRequest = "/select?q=";
        String columns = "*";
        String type = "&wt=json&indent=true";

        SolrServer solr = new HttpSolrServer("http://localhost:8983/solr/gimme5collection"); //create solr connection

        //----------------------------------------------------------
        //create query


        SolrQuery query = new SolrQuery();
        query.setQuery("entry_name:robert bosch");
        query.addFilterQuery("category_name:company");
        query.addField("location_name:kormangala");
        query.setFields("location_name");
      //  query.setHighlight(true);


        System.out.println("Query: " + query);

        QueryResponse response = null;
        try {
            response = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        List<ActivitiesDocument> activitiesDocumentList = new ArrayList<>();
        SolrDocumentList docList = (SolrDocumentList) response.getResults();
        int docCount = docList.size();

        //document fields

        for (int i = 0; i < docCount; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            ActivitiesDocument activitiesDocument = new ActivitiesDocument();

            activitiesDocument.setId(docList.get(i).getFieldValue("id").toString());

            activitiesDocument.setEntry_name((docList.get(i).getFieldValue("entry_name")).toString());

            activitiesDocument.setCategory_name(docList.get(i).getFieldValue("category_name").toString());

            activitiesDocument.setLocation_name(docList.get(i).getFieldValue("location_name").toString());

            activitiesDocumentList.add(activitiesDocument);

        }

        for (ActivitiesDocument activitiesDocument : activitiesDocumentList){
            System.out.println(activitiesDocument.toString());
        }




        //server.query(SolrParams.toSolrParams(new NamedList("location_name" ,"" )), SolrRequest.METHOD.GET)
    }}
