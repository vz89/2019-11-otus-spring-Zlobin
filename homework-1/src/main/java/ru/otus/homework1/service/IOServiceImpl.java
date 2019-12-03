package ru.otus.homework1.service;

import java.util.Scanner;

public class IOServiceImpl implements IOService {
    private Scanner sc = new Scanner(System.in);
    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public Integer readInt() {
        return sc.nextInt();
    }
}
