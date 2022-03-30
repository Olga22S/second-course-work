package pro.sky.secondcoursework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.exeption.NotAllowedActionException;
import pro.sky.secondcoursework.model.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);

    public MathQuestionService() {
    }

    @Override
    public Question add(String question, String answer) {
        throw new NotAllowedActionException();
    }

    @Override
    public Question add(Question question) {
        throw new NotAllowedActionException();
    }

    @Override
    public Question remove(Question question) {
        throw new NotAllowedActionException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new NotAllowedActionException();
    }

    @Override
    public Question getRandomQuestion() {
        logger.info("Generating math question.");
        int firstNum = new Random().nextInt(100);
        int secondNum = new Random().nextInt(100);
        int answer = firstNum + secondNum;
        Question question = new Question((firstNum + "+" + secondNum), (" = " + answer));
        logger.info("Math question was generated: " + question);
        return question;
    }
}
