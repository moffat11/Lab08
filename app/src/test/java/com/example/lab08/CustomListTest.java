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
}
