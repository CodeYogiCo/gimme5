package com.phantom.model.storage;

import com.phantom.entity.Categories;
import com.phantom.model.CategoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by vishal on 14/11/15.
 */

@Component
public class CategoriesDaoImpl  implements CategoriesDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    private void setDataSource(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }

    @Override
    public void addNewCategory(Categories category) {

    }

    @Override
    public List<String> getCategoryAttribute(String categoryName) {
        return null;
    }
}
