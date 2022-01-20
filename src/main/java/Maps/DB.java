package Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB {
    private static DB instance;
    private List<String> sectors;

    private DB() {}

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }

        return instance;
    }

    public void addSectors(String sectors[]) {
        if (this.sectors == null) {
            this.sectors = new ArrayList<String>();
        }

        Arrays.stream(sectors).forEach(sector -> {
            this.sectors.add(sector);
        });
    }

    public String getSectorById(int id) {
        return sectors.get(id);
    }
}
