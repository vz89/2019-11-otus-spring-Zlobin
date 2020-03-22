package ru.otus.homework.service;

import org.springframework.stereotype.Service;

@Service
public class WarDepartmentServiceImpl implements WarDepartmentService {
    @Override
    public void Message() {
        System.out.println("WarDepartmentService");
    }
}
