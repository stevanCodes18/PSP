package com.stevancodes18.tema01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Robot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String linea;
        while ((linea = br.readLine()) != null) {
            String transformada = linea.toUpperCase();
            System.out.println(transformada + " [" + transformada.length() + " caracteres]");
        }
    }
}
