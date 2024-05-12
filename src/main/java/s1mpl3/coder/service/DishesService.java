package s1mpl3.coder.service;

import s1mpl3.coder.dao.DishesDao;
import s1mpl3.coder.domain.Dishes;
import s1mpl3.coder.dtos.AppErrorDTO;
import s1mpl3.coder.dtos.DataDTO;
import s1mpl3.coder.dtos.ResponseEntity;
import s1mpl3.coder.exceptions.GenericNotFoundException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class DishesService implements BaseService<Dishes> {

    FindServise findServise = new FindServise();
    private final DishesDao dao = new DishesDao();
    public ResponseEntity<DataDTO<List<Dishes>>> findAll(String sort) {
        try {
            List<Dishes>dishes = dao.findAll();
            if (dishes.isEmpty()){
                throw new GenericNotFoundException("Dishes not found!");
            }
            switch (sort){
                case "1" -> dishes.sort(Comparator.comparing(Dishes::getId));
                case "2" -> dishes.sort(Comparator.comparing(Dishes::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(dishes));
        } catch (IOException | GenericNotFoundException e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Dishes>>> findById(Long id) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    findServise.search(String.valueOf(id),String.valueOf(dishes1.getId()))).toList();
            if (dishes == null) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes),200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Dishes>>> findByName(String name) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    findServise.search(name,dishes1.getName())).toList();
            if (dishes == null) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Dishes>>> findByColor(String color) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    findServise.search(color,dishes1.getColor())).toList();
            if (dishes.isEmpty()) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Dishes>>> findByPrice(Double min, Double max) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    dishes1.getPrice() >= min && dishes1.getPrice() <= max).toList();
            if (dishes.isEmpty()) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
    public ResponseEntity<DataDTO<List<Dishes>>> findByMaterial(String material) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    findServise.search(material,String.valueOf(dishes1.getMaterial()))).toList();
            if (dishes.isEmpty()) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
    public ResponseEntity<DataDTO<List<Dishes>>> findByWeight(String weight) {
        try {
            List<Dishes> dishes = dao.findAll().stream().filter(dishes1 ->
                    findServise.search(weight,dishes1.getWeight())).toList();
            if (dishes.isEmpty()) {
                throw new GenericNotFoundException("Dishes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(dishes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
}
