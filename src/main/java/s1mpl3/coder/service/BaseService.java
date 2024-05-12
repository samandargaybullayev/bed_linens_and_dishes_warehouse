package s1mpl3.coder.service;

import s1mpl3.coder.domain.Dishes;
import s1mpl3.coder.dtos.DataDTO;
import s1mpl3.coder.dtos.ResponseEntity;

import java.util.List;

public interface BaseService<T> {
    ResponseEntity<DataDTO<List<T>>> findAll(String sort);

    ResponseEntity<DataDTO<List<T>>> findById(Long id);

    ResponseEntity<DataDTO<List<T>>> findByName(String name);

    ResponseEntity<DataDTO<List<T>>> findByColor(String color);

    ResponseEntity<DataDTO<List<T>>> findByPrice(Double min, Double max);
}