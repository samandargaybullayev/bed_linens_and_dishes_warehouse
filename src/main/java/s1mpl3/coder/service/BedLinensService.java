package s1mpl3.coder.service;

import s1mpl3.coder.dao.BedLinensDao;
import s1mpl3.coder.domain.BedLinens;
import s1mpl3.coder.dtos.AppErrorDTO;
import s1mpl3.coder.dtos.DataDTO;
import s1mpl3.coder.dtos.ResponseEntity;
import s1mpl3.coder.exceptions.GenericNotFoundException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class BedLinensService implements BaseService<BedLinens> {
    private final BedLinensDao dao = new BedLinensDao();
    public ResponseEntity<DataDTO<List<BedLinens>>> findAll(String sort) {
        try {
            List<BedLinens>bedLinens = dao.findAll();
            if (bedLinens.isEmpty()){
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            switch (sort){
                case "1" -> bedLinens.sort(Comparator.comparing(BedLinens::getId));
                case "2" -> bedLinens.sort(Comparator.comparing(BedLinens::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens));
        } catch (IOException | GenericNotFoundException e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
    FindServise findServise = new FindServise();

    @Override
    public ResponseEntity<DataDTO<List<BedLinens>>> findById(Long id) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                   findServise.search(String.valueOf(id),String.valueOf(bedLinens1.getId())) ).toList();
            if (bedLinens == null) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens),200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<BedLinens>>> findByName(String name) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                    findServise.search(name,bedLinens1.getName())).toList();
            if (bedLinens == null) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<BedLinens>>> findByColor(String color) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                    findServise.search(color,bedLinens1.getColor())).toList();
            if (bedLinens.isEmpty()) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<BedLinens>>> findByPrice(Double min, Double max) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                    bedLinens1.getPrice() >= min && bedLinens1.getPrice() <= max).toList();
            if (bedLinens.isEmpty()) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }

    public ResponseEntity<DataDTO<List<BedLinens>>> findBymaterial(String material) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                    findServise.search(material,bedLinens1.getMaterial())).toList();
            if (bedLinens.isEmpty()) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
    public ResponseEntity<DataDTO<List<BedLinens>>> findByweight(String weight) {
        try {
            List<BedLinens> bedLinens = dao.findAll().stream().filter(bedLinens1 ->
                    findServise.search(weight,bedLinens1.getWeight())).toList();
            if (bedLinens.isEmpty()) {
                throw new GenericNotFoundException("Bed Linens not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(bedLinens), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(new AppErrorDTO(e.getMessage(), e.getMessage())), 400);
        }
    }
}