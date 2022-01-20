package Maps;

import java.lang.constant.Constable;

public class Sector implements ISector {
    private int id;
    private String imageUrl;
    private int northSectorId;
    private int southSectorId;
    private int eastSectorId;
    private int westSectorId;

    public Sector(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }

    private int parseToNumber(String number) {
        if (number.contains("null")) {
            return -1;
        }

        return  Integer.parseInt(number);
    }

    private void loadingInfo() {
        if (imageUrl != null) {
            return;
        }

        String sectorStr = DB.getInstance().getSectorById(this.id);

        String values[] = sectorStr.split(",");


        northSectorId = parseToNumber(values[1]);
        eastSectorId = parseToNumber(values[2]);
        southSectorId = parseToNumber(values[3]);
        westSectorId = parseToNumber(values[4]);
        imageUrl = values[5];
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getImageUrl() {
        loadingInfo();
        return this.imageUrl;
    }

    @Override
    public Sector getSectorNorth() {
        loadingInfo();

        if (northSectorId < 0) {
            return null;
        }

        return new Sector(northSectorId);
    }

    @Override
    public Sector getSectorSouth() {
        loadingInfo();
        if (southSectorId < 0) {
            return null;
        }

        return new Sector(southSectorId);
    }

    @Override
    public Sector getSectorEast() {
        loadingInfo();
        if (eastSectorId < 0) {
            return null;
        }

        return new Sector(eastSectorId);
    }

    @Override
    public Sector getSectorWest() {
        loadingInfo();
        if (westSectorId < 0) {
            return null;
        }

        return new Sector(westSectorId);
    }
}
