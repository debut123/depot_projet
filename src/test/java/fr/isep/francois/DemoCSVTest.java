package fr.isep.francois;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DemoCSVTest {

    @org.junit.jupiter.api.Test
    void lireCSV_testNotnull() {
        try {
            assertEquals(DemoCSV.lireCSV().get(1).get("Dép"),"Lyon");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}