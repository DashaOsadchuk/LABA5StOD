package com.main;

import java.util.HashSet;
import java.util.Random;

public class Main {

    String dictionary = "0123456789";
    String dictionary_ = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        HashTable<Integer, String> map = new HashTable<>();
        System.out.println("Кол-во: "+map.capacity());
        System.out.println("Мое выполнение");
        Random rnd = new Random();
        long first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int steps = rnd.nextInt(6)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < steps; j++) {
                builder.append(dictionary.charAt(rnd.nextInt(dictionary.length())));
            }
            map.put(rnd.nextInt(1000000), builder.toString());
        }
        double time = System.currentTimeMillis()-first;
        System.out.println("Время за которое добавилось 1000000 элементов: "+time/1000+"с;");
        first = System.currentTimeMillis();
        int successful = 0, unsuccessful = 0;
        for (int i = 0; i < 1000000; i++) {
            int steps = rnd.nextInt(6)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < steps; j++) {
                builder.append(dictionary.charAt(rnd.nextInt(dictionary.length())));
            }
            if (map.contains(Integer.parseInt(builder.toString()))) successful++;
            else unsuccessful++;
        }
        time = System.currentTimeMillis() - first;
        System.out.println("Время за которое находит случайный 1000000 елемент: "+time/1000+"с; Успешно найден: "+successful+", Безуспешно: "+unsuccessful);
        HashSet<String> stdMap = new HashSet<>();
        first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int steps = rnd.nextInt(6)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < steps; j++) {
                builder.append(dictionary.charAt(rnd.nextInt(dictionary.length())));
            }
            stdMap.add(builder.toString());
        }
        System.out.println("\nВыполнение стандартной библиотеки");
        time = System.currentTimeMillis()-first;
        System.out.println("Время за которое добавилось 1000000 элементов: "+time/1000+"с;");
        first = System.currentTimeMillis();
        successful = 0; unsuccessful = 0;
        for (int i = 0; i < 1000000; i++) {
            int steps = rnd.nextInt(6)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < steps; j++) {
                builder.append(dictionary.charAt(rnd.nextInt(dictionary.length())));
            }
            if (stdMap.contains(builder.toString())) successful++;
            else unsuccessful++;
        }
        time = System.currentTimeMillis() - first;
        System.out.println("Время за которое находит случайный 1000000 елемент: "+time/1000+"с;  Успешно найден: "+successful+", Безуспешно: "+unsuccessful);
    }
}
