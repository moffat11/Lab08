package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    public void testHasCity(){
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "All");
        list.addCity(calgary);

        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void deleteCity_removesOrThrows() {
        CustomList list = new CustomList();
        City cal = new City("Calgary", "AB");
        City van = new City("Vancouver", "BC");

        list.addCity(cal);
        assertTrue(list.hasCity(cal));

        // delete existing
        list.deleteCity(cal);
        assertFalse(list.hasCity(cal));

        // deleting a city that doesn't exist should throw
        try {
            list.deleteCity(van);
            fail("Expected IllegalArgumentException when deleting missing city");
        } catch (IllegalArgumentException expected) {
            // pass
        }
    }

    @Test
    public void countCities_countsAccurately() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());

        list.addCity(new City("Edmonton", "AB"));
        assertEquals(1, list.countCities());

        list.addCity(new City("Calgary", "AB"));
        assertEquals(2, list.countCities());

        // adding a duplicate should fail and not change count (bonus safety)
        try {
            list.addCity(new City("Calgary", "AB"));
            fail("Expected IllegalArgumentException on duplicate add");
        } catch (IllegalArgumentException expected) {
            // pass
        }
        assertEquals(2, list.countCities());
    }
}
