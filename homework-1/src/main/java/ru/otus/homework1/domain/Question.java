package ru.otus.homework1.domain;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> answers;
    private int rightAnswer;

    public Question(String question, ArrayList<String> answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
