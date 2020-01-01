package ru.otus.homework.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
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

    @Override
    public void write(int count) {
        System.out.println(count);
    }
}
