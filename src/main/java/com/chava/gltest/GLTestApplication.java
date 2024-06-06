package com.chava.gltest;

import com.chava.gltest.service.interfaces.IServiceLetraMasRepetida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
        Given an input String, e.g.:
        String input = “aaabejhfdjaxxaaddddaaaaaaafkjn3ijfiowjfoisdjfopijpi”;
        Create a function that prints the letter with the maximum count.

        Agregar prueba unitaria JUnit
 */

@SpringBootApplication
public class GLTestApplication implements CommandLineRunner {

    @Autowired
    private IServiceLetraMasRepetida serviceLetraMasRepetida;

    public static void main(String[] args) {
        SpringApplication.run(GLTestApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Iniciando Prueba GL...");

        System.out.println("Given an input String, create a function that prints the letter with the maximum count. Add a Unit TEST");

        String input = "aaabejhfdjaxxaaddddaaaaaaafkjn3ijfiowjfoisdjfopijpi";

        System.out.println("Palabra a contabilizar: " + input);

        String response = serviceLetraMasRepetida.encuentraLetraMasRepetida(input);

        System.out.println(response);
    }
}
