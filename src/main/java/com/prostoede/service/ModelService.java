package com.prostoede.service;
import com.prostoede.model.Model;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author ProstoEde 27.09.2018
 * Интерфейс ModelService
 */
public interface ModelService {
    RowMapper<Model> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Model(resultSet.getInt(1) ,resultSet.getString("name"));
    };
    int saveModel(Model model);
    List<Model> getList();
    List<Model> getListSortName(String name);
    List<Model> getListSortId(int id);
    List<Model> getListSort(int id, String name);

}
