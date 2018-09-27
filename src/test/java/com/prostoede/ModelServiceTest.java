package com.prostoede;

import com.prostoede.model.Model;
import com.prostoede.service.ModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ProstoEde 27.09.2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ApplicationContext.xml")
public class ModelServiceTest {
    @Autowired
    private ModelService modelService;
    @Test
    public void test1() {

        Model model = new Model();
        model.setName("Тестовая модель1");

        modelService.saveModel(model);

        //проверим, что модель успешно сохранилась

        List<Model> models = modelService.getList();
        assertEquals(1, models.size()); //проверяем, что нам вернётся один элемент (база пустая)

        Model modelFromBase = models.stream().findFirst().get();

        assertNotNull(modelFromBase);
        assertEquals("Тестовая модель1", modelFromBase.getName());


    }

}

