package ru.otus.homework1.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.otus.homework1.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service

public class QuestionDaoImpl implements QuestionDao {

    final private String filename;

    private static final int QUESTION_INDEX=0;
    private static final int ANSWER_INDEX=5;

    public QuestionDaoImpl(@Value("${filename}")String filename) {
        this.filename = filename;
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:" + filename);
            // BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line = null;
            Scanner scanner = null;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                ArrayList<String> answers = new ArrayList<>();
                Question question = new Question();

                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == QUESTION_INDEX) {
                        question.setQuestion(data);
                    } else if ((index > QUESTION_INDEX) && (index < ANSWER_INDEX)) {
                        answers.add(data);
                    } else if (index == ANSWER_INDEX) {
                        question.setRightAnswer(Integer.parseInt(data));
                    } else throw new Error("Неправильный формат данных СSV файла");
                    index++;
                }
                index = 0;
                question.setAnswers(answers);
                questions.add(question);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return questions;
    }

}
