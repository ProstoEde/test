package com.prostoede.service;
import com.prostoede.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author ProstoEde 27.09.2018
 * Класс ModelServiceImpl реализует методы интерфейса ModelService
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
    /**
     * Метод сохранения объекта модели
     * @param - Объект модели который нужно сохранить
     * @return - id сохраненного объекта
     */
    @Override
    @Transactional
    public int saveModel(Model model) {
        String sql = "insert into person(name) values('"+model.getName()+"')";
        return jdbcTemplate.update(sql);
    }
    /**
     * Метод выборки всех объектов из БД
     * @return - Список всех объектов БД в виде List
     */
    @Override
    @Transactional
    public List<Model> getList() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    /**
     * Метод выборки объектов из БД по NAME
     * @param - name
     * @return - Список объектов из БД у которых поле NAME == параметру name
     */
    @Override
    @Transactional
    public List<Model> getListSortName(String name) {
        String sql = "select * from person WHERE NAME = '"+name+"' ";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    /**
     * Метод выборки объектов из БД по ID
     * @param - id
     * @return - Список объектов из БД у которых поле ID == параметру id
     */
    @Override
    @Transactional
    public List<Model> getListSortId(int id) {
        String sql = "select * from person WHERE ID = '"+id+"'";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    /**
     * Метод выборки объектов из БД по NAME и ID
     * @param - id, name
     * @return - Список объектов из БД у которых поле ID == параметру id и NAME == параметру name
     */
    @Override
    @Transactional
    public List<Model> getListSort(int id, String name) {
        String sql = "select * from person WHERE ID = '"+id+"' AND NAME = '"+name+"'";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
}
