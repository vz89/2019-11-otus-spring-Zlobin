package ru.otus.homework1.domain;

import java.util.List;

public class Testing {
    private Person person;
    private List<Question> questions;
    private boolean result;



    public Testing(Person person, List<Question> questions) {
        this.person = person;
        this.questions = questions;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
