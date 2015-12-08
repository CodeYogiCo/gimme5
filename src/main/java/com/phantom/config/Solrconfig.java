package com.phantom.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vishal on 12/8/15.
 */

@Configuration
public class Solrconfig {

    @Bean
    public SolrServer setSolr(){
        SolrServer solr = new HttpSolrServer("http://localhost:8983/solr/gimme5collection");
        return solr;

    }
}
