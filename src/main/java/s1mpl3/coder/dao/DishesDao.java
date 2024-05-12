package s1mpl3.coder.dao;

import s1mpl3.coder.config.CustomFileReader;
import s1mpl3.coder.domain.Dishes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DishesDao implements BaseDao<Dishes> {
    private final String DishesFile = "src/main/resources/dishes.csv";
    private final CustomFileReader fileReader = new CustomFileReader();
    @Override
    public List<Dishes> findAll() throws IOException {
        return readDishesFile();
    }
    public List<Dishes> readDishesFile() throws IOException {
        List<Dishes> dishes = new ArrayList<>();
        List<String> strings = fileReader.readFile(DishesFile);
        strings.forEach(s -> dishes.add(toDishes(s)));
        return dishes;
    }
    private Dishes toDishes(String line){
        String[] strings = line.split(",");
        return new Dishes(Long.valueOf(strings[0]), strings[1], strings[2], Double.parseDouble(strings[3]),
                Integer.valueOf(strings[4]), strings[5], Integer.valueOf(strings[6]), strings[7]);
    }
}
