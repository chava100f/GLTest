package com.chava.gltest.service;

import com.chava.gltest.service.interfaces.IServiceLetraMasRepetida;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceLetraMasRepetida implements IServiceLetraMasRepetida {

    public String encuentraLetraMasRepetida(String input){

        if(input == null){
            return "La palabra es nula, ergo no hay letra mas repetida";
        }
        if(input.isEmpty()){
            return "La palabra esta vacía, ergo no hay letra mas repetida";
        }

        Map<Character, Integer> conteoGral = new HashMap<Character, Integer>();

        char [] inputArray = input.toCharArray();

        for(int i = 0; i < input.length(); i++){
            int valor = conteoGral.getOrDefault(inputArray[i],0);
            conteoGral.put(inputArray[i], valor + 1);
        }

        char letraMasRepetida = ' ';
        int repeticiones = 0;

        for(Map.Entry<Character, Integer> entry : conteoGral.entrySet()){
            if(entry.getValue() > repeticiones){
                letraMasRepetida = entry.getKey();
                repeticiones = entry.getValue();
            }

        }

        return "El caracter mas repetido es: " + letraMasRepetida + ", apareciendo " + repeticiones + " veces.";

    }
}
