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
        int firstNum = random.nextInt(100);
        int secondNum = random.nextInt(100);
        int answer = firstNum + secondNum;
        Question question = new Question((firstNum + "+" + secondNum), String.valueOf(answer));
        logger.info("Math question was generated: " + question);
        return question;
    }
}
