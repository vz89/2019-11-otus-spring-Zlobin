package ru.otus.homework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.otus.homework.config.ApplicationSettings;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.QuestionsReadingFailedException;
import ru.otus.homework.exception.InvalidQuestionsDataException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionDaoImpl implements QuestionDao {

    final private String csvFileName;

    @Autowired
    public QuestionDaoImpl(ApplicationSettings settings) {
        this.csvFileName = settings.getCsvFileName();
    }

    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 5;


    public List<Question> getQuestions() throws QuestionsReadingFailedException {
        List<Question> questions = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:" + csvFileName);
            // BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line = null;
            Scanner scanner = null;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                List<String> answers = new ArrayList<>();
                Question question = new Question();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                parseCsvString(scanner, index, answers, question);
                index = 0;
                question.setAnswers(answers);
                questions.add(question);
            }
        } catch (IOException e) {
            throw new QuestionsReadingFailedException("Невозможно прочитать CSV файд",e);
        }
        catch (InvalidQuestionsDataException e){
            System.out.println("Неправильный формат данных СSV файла");
        }
        return questions;
    }

    private void parseCsvString(Scanner scanner, int index, List<String> answers, Question question) throws InvalidQuestionsDataException {
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == QUESTION_INDEX) {
                question.setQuestion(data);
            } else if ((index > QUESTION_INDEX) && (index < ANSWER_INDEX)) {
                answers.add(data);
            } else if (index == ANSWER_INDEX) {
                question.setRightAnswer(Integer.parseInt(data));
            } else throw new InvalidQuestionsDataException("Неправильный формат данных СSV файла");
            index++;
        }
    }
}
