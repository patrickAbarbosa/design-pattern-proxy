package Maps;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectorTest {
    @BeforeAll
    public static void init() {
        String sectors[] = {
                "0,null,1,3,null,https://maps.pk.dev/image1.jpg",
                "1,null,2,4,0,https://maps.pk.dev/image2.jpg",
                "2,null,null,5,1,https://maps.pk.dev/image3.jpg",
                "3,0,4,6,null,https://maps.pk.dev/image4.jpg",
                "4,1,5,7,3,https://maps.pk.dev/image5.jpg",
                "5,2,null,8,4,https://maps.pk.dev/image6.jpg",
                "6,3,7,null,null,https://maps.pk.dev/image7.jpg",
                "7,4,8,null,6,https://maps.pk.dev/image8.jpg",
                "8,5,null,null,7,https://maps.pk.dev/image9.jpg",
        };

        DB.getInstance().addSectors(sectors);
    }

    @Test
    public void shouldReturnSectorNorth() {
        Sector sector = new Sector(4);

        assertEquals(1, sector.getSectorNorth().getId());
    }

    @Test
    public void shouldReturnSectorEast() {
        Sector sector = new Sector(3);

        assertEquals(4, sector.getSectorEast().getId());
    }

    @Test
    public void shouldReturnSector() {
        Sector sector = new Sector(8);

        assertEquals(7, sector.getSectorWest().getId());
    }

    @Test
    public void shouldReturnSectorSouth() {
        Sector sector = new Sector(3);

        assertEquals(6, sector.getSectorSouth().getId());
    }

    @Test
    public void shouldReturnImageUrl() {
        Sector sector = new Sector(4);

        assertEquals("https://maps.pk.dev/image5.jpg", sector.getImageUrl());
    }
}