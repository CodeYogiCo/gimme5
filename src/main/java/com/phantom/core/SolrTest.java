package com.phantom.core;

import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;

/**
 * Created by vishal on 30/11/15.
 */
public class SolrTest {

    public static void main(String[] args) {
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr/gimmeFiveCollection2");

        server.query(SolrParams.toSolrParams(new NamedList("location_name" ,"" )), SolrRequest.METHOD.GET)
    }}
