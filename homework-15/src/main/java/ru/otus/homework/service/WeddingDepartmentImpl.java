package ru.otus.homework.service;

import org.springframework.stereotype.Service;

@Service
public class WeddingDepartmentImpl implements WeddingDepartment {
    @Override
    public void Message() {
        System.out.println("WeddingDepartment");
    }
}
