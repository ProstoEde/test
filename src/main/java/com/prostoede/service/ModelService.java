package com.prostoede.service;

import com.prostoede.model.Model;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.util.List;

/**
 * Интерфейс ModelService
 * @author ProstoEde 27.09.2018
 */
public interface ModelService {
    RowMapper<Model> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Model(resultSet.getInt(1) ,resultSet.getString("name"));
    };

    /**
     * Метод сохранения объекта модели
     * @param - Объект модели который нужно сохранить
     * @return - id сохраненного объекта
     */
    int saveModel(Model model);

    /**
     * Метод выборки всех объектов из БД
     * @return - Список всех объектов БД в виде List
     */
    List<Model> getList();

    /**
     * Метод выборки объектов из БД по NAME
     * @param - name
     * @return - Список объектов из БД у которых поле NAME == параметру name
     */
    List<Model> getListSortName(String name);

    /**
     * Метод выборки объектов из БД по ID
     * @param - id
     * @return - Список объектов из БД у которых поле ID == параметру id
     */
    List<Model> getListSortId(int id);

    /**
     * Метод выборки объектов из БД по NAME и ID
     * @param - id, name
     * @return - Список объектов из БД у которых поле ID == параметру id и NAME == параметру name
     */
    List<Model> getListSort(int id, String name);

}
