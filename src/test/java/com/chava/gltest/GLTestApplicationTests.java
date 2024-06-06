package com.chava.gltest;

import com.chava.gltest.service.interfaces.IServiceLetraMasRepetida;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GLTestApplicationTests {

    @Autowired
    private IServiceLetraMasRepetida serviceLetraMasRepetida;

    private String input1 = "aaabejhfdjaxxaaddddaaaaaaafkjn3ijfiowjfoisdjfopijpi";
    private String input2 = "aaabejhfdjaxxaaddddaaaaaaafkjn3ijfiowjfoisdddddddddddddddddddddddddjfopijpi";
    private String input3 = "abcdeff";
    private String input4 = "1231231231";
    private String input5 = "---!#%%/#%&\"\"/&#$%#$___asddfiwufuihsd1231231231";
    private String input6 = "";
    private String input7 = null;

    @Test
    void contextLoads() throws Exception{
        assertThat(serviceLetraMasRepetida).isNotNull();
    }

    @Test
    void testServiceLetraMasRepetidaPorDefecto() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input1)).isNotNull().contains(
                "El caracter mas repetido es: a, apareciendo 13 veces.");
    }
    @Test
    void testServiceLetraMasRepetidaStringMasLargo() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input2)).isNotNull().contains(
                "El caracter mas repetido es: d, apareciendo 30 veces.");
    }
    @Test
    void testServiceLetraMasRepetidaStringCorto() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input3)).isNotNull().contains(
                "El caracter mas repetido es: f, apareciendo 2 veces.");
    }
    @Test
    void testServiceLetraMasRepetidaNumeros() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input4)).isNotNull().contains(
                "El caracter mas repetido es: 1, apareciendo 4 veces.");
    }
    @Test
    void testServiceLetraMasRepetidaLetrasNumerosYSimbolos() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input5)).isNotNull().contains(
                "El caracter mas repetido es: #, apareciendo 4 veces.");
    }
    @Test
    void testServiceLetraMasRepetidaVacio() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input6)).isNotNull().contains(
                "La palabra esta vacía, ergo no hay letra mas repetida");
    }
    @Test
    void testServiceLetraMasRepetidaNulo() throws Exception{
        assertThat(serviceLetraMasRepetida.encuentraLetraMasRepetida(input7)).isNotNull().contains(
                "La palabra es nula, ergo no hay letra mas repetida");
    }

}
