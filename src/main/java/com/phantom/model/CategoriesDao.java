package com.phantom.model;

import com.phantom.entity.Categories;

import java.util.List;

/**
 * Created by vishal on 14/11/15.
 */
public interface CategoriesDao {

    void addNewCategory(Categories category);

    List<String> getCategoryAttribute(String categoryName);


}
