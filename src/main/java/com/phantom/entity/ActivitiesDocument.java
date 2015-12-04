package com.phantom.entity;
import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by vishal on 30/11/15.
 */
public class ActivitiesDocument {

    public ActivitiesDocument() {
    }

    public String id;

    public String category_name;

    public String entry_name;

    public String location_name;

    public String speciality_name;

    public ActivitiesDocument(String id, String category_name, String entry_name, String location_name, String speciality_name) {
        this.id = id;
        this.category_name = category_name;
        this.entry_name = entry_name;
        this.location_name = location_name;
        this.speciality_name = speciality_name;
    }

    public String getId() {
        return id;
    }

    @Field("id")
    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }
    @Field("category_name")
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getEntry_name() {
        return entry_name;
    }
    @Field("entry_name")
    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }

    public String getLocation_name() {
        return location_name;
    }
    @Field("location_name")
    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }
    @Field("speciality_name")
    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }
}
