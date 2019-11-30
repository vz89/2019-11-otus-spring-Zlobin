package ru.otus.homework1.dao;

import org.springframework.util.ResourceUtils;
import ru.otus.homework1.domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionDaoImpl implements QuestionDao {

    public List<Question> getQuestions(String filename) {
        List<Question> questions = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:"+filename);
           // BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"windows-1251"));
            String line = null;
            Scanner scanner = null;
            int index = 0;

            while ((line=reader.readLine())!=null) {
                ArrayList<String> answers = new ArrayList<>();
                Question question = new Question();

                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()){
                    String data = scanner.next();
                    if (index == 0){
                        question.setQuestion(data);
                    }
                    else if ((index>0) && (index<5)){
                        answers.add(data);
                    }
                    else if (index==5){
                        question.setRightAnswer(Integer.parseInt(data));
                    }
                    else System.out.println("Некорректные данные");
                    index++;
                }
                index=0;
                question.setAnswers(answers);
                questions.add(question);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return questions;
    }
}
