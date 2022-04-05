package pro.sky.secondcoursework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.exeption.ActionNotAllowedException;
import pro.sky.secondcoursework.model.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);
    private final Random random = new Random();

    public MathQuestionService() {
    }

    @Override
    public Question add(String question, String answer) {
        throw new ActionNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new ActionNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new ActionNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new ActionNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        logger.info("Generating math question.");
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        char operator = generateOperator();
        int answer = getCalculatingResult(a, b, operator);
        Question question = new Question(a + " " + operator + " " + b, String.valueOf(answer));
        logger.info("Math question was generated: " + question);
        return question;
    }

    private char generateOperator() {
        char[] operators = {'+', '-', '*', '/'};
        int index = random.nextInt(operators.length);
        return operators[index];
    }

    private int getCalculatingResult(int a, int b, char operator) {
        if (b == 0 && operator == '/') {
            throw new IllegalArgumentException("It's forbidden to divide by zero!");
        }
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Not such operator");
        }
    }
}
