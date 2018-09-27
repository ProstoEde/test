package com.prostoede.controller;
import com.prostoede.model.Model;
import com.prostoede.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author ProstoEde 27.09.2018
 * Класс ModelController
 */
@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    //Главная страница
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView getStart(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        return modelAndView;
    }

    //Вывод списка имен из бд
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getListPerson(){
        ModelAndView modelAndView = new ModelAndView();
        List<Model> list = modelService.getList();
        modelAndView.addObject("userJSP", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }
    //Страница добавить, после нажатия кнопки переходим к check
    @RequestMapping(value = "/add")
    protected ModelAndView model(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP",new Model());
        modelAndView.setViewName("add");
        return modelAndView;

    }

    //Добавляем запись в бд и возвращаемся на главную страницу
    @RequestMapping(value = "/check")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView checkUser(@ModelAttribute("userJSP") Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        modelAndView.addObject("userJSP", model);
        modelService.saveModel(model);
        System.out.println(model);
        return modelAndView;
    }
    //Вывод списка имен из бд по поиску
    @RequestMapping(value = "/sort")
    public ModelAndView getListSort(@RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "id",required = false) Integer  id ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        if(id!=null&&name!=null&&!name.isEmpty()){
            List<Model> list = modelService.getListSort(id, name);
            modelAndView.addObject("userJSP", list);
        }else if (id == null&&name!=null&&!name.isEmpty()) {
                List<Model> list = modelService.getListSortName(name);
                modelAndView.addObject("userJSP", list);
        }else if(id!=null){
            List<Model> list = modelService.getListSortId(id);
            modelAndView.addObject("userJSP", list);
        }
        return modelAndView;
    }



}
