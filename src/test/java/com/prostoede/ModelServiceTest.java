package com.prostoede;

import com.prostoede.model.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ProstoEde
 */
@RunWith(SpringJUnit4ClassRunner.class)

public class ModelServiceTest extends ModelServiceTestConnection{

    @Test
    public void test1() throws Exception {
        initDataBaseTest1();
        Model model = new Model();
        model.setName("Тестовая модель 1");
        getModelService().saveModel(model);
        List<Model> models = getModelService().getList();
        assertEquals(1, models.size());
        Model modelFromBase = models.stream().findFirst().get();
        assertNotNull(modelFromBase);
        assertEquals("Тестовая модель 1", modelFromBase.getName());
    }

    @Test
    public void test2() throws Exception{
        initDataBaseTest2();
        Model model;
        List<Model> list = getModelService().getListSortName("Тестовая модель 1");
        model = list.stream().findFirst().get();
        assertEquals("Тестовая модель 1", model.getName());
    }


}
