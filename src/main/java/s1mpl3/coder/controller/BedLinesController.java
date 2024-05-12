package s1mpl3.coder.controller;

import s1mpl3.coder.domain.BedLinens;
import s1mpl3.coder.dtos.DataDTO;
import s1mpl3.coder.dtos.ResponseEntity;
import s1mpl3.coder.service.BedLinensService;
import s1mpl3.coder.utils.BaseUtils;

import java.util.List;

public class BedLinesController implements BaseController{
    private final BedLinensService service = new BedLinensService();
    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByName() {
        BaseUtils.print("Enter name: ");
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findByName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findBymaterial() {
        BaseUtils.print("Enter material: ");
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findBymaterial(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByweight() {
        BaseUtils.print("Enter time weight: ");
        ResponseEntity<DataDTO<List<BedLinens>>> responseEntity = service.findByweight(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
