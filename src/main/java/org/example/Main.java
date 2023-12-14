package org.example;

import org.example.controller.GeneralController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GeneralController generalController = new GeneralController();
        generalController.getIndexName("2010-01-01", "1422396, 1450759, 1449192, 1451562");
    }
}