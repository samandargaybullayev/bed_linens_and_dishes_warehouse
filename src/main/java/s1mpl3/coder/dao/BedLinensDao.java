package s1mpl3.coder.dao;

import s1mpl3.coder.config.CustomFileReader;
import s1mpl3.coder.domain.BedLinens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BedLinensDao implements BaseDao<BedLinens> {
    private final String BedLinensFile = "src/main/resources/bed_linens.csv";
    private final CustomFileReader fileReader = new CustomFileReader();
    @Override
    public List<BedLinens> findAll() throws IOException {
        return readBedLinensFile();
    }
    public List<BedLinens> readBedLinensFile() throws IOException {
        List<BedLinens> bedLinens = new ArrayList<>();
        List<String> strings =fileReader.readFile(BedLinensFile);
        strings.forEach(s -> bedLinens.add(toBedLinens(s)));
        return bedLinens;
    }

    private BedLinens toBedLinens(String line){
        String[] strings = line.split(",");
        return new BedLinens(Long.valueOf(strings[0]), strings[1], strings[2], Double.parseDouble(strings[3]),
                Integer.valueOf(strings[4]), strings[5], strings[6], strings[7]);
    }
}
