package s1mpl3.coder.controller;

import s1mpl3.coder.domain.Dishes;
import s1mpl3.coder.dtos.DataDTO;
import s1mpl3.coder.dtos.ResponseEntity;
import s1mpl3.coder.service.DishesService;

import s1mpl3.coder.utils.BaseUtils;

import java.util.List;

public class DishesController implements BaseController {
    private final DishesService service = new DishesService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByName() {
        BaseUtils.print("Enter name: ");
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findByName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByMaterial() {
        BaseUtils.print("Enter Material: ");
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findByMaterial(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWeight() {
        BaseUtils.print("Enter Weight: ");
        ResponseEntity<DataDTO<List<Dishes>>> responseEntity = service.findByWeight(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}