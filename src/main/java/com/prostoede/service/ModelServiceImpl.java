package com.prostoede.service;

import com.prostoede.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.util.List;

/**
 * Класс ModelServiceImpl реализует методы интерфейса ModelService
 * @author ProstoEde 27.09.2018
 */
@Component
public class ModelServiceImpl implements ModelService {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    @Transactional
    public int saveModel(Model model) {
        String sql = "insert into person(name) values('"+model.getName()+"')";
        return jdbcTemplate.update(sql);
    }


    @Override
    @Transactional
    public List<Model> getList() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }


    @Override
    @Transactional
    public List<Model> getListSortName(String name) {
        String sql = "select * from person WHERE NAME LIKE '"+name+"%' ";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }


    @Override
    @Transactional
    public List<Model> getListSortId(int id) {
        String sql = "select * from person WHERE ID = '"+id+"'";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }


    @Override
    @Transactional
    public List<Model> getListSort(int id, String name) {
        String sql = "select * from person WHERE ID = '"+id+"' AND NAME = '"+name+"'";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
}
