package pro.sky.secondcoursework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.repository.QuestionRepository;

import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);
    private final Random random = new Random();

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionRepository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        logger.info("Add java question= " + question);
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        logger.info("Remove java question= " + question);
        return questionRepository.remove(question);
    }

    @Override
    public List<Question> getAll() {
        logger.info("Getting all java questions.");
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        logger.info("Generating random java question...");
        int i = random.nextInt(questionRepository.getAll().size());
        Question returnedQuestion = getAll().get(i);
        logger.info("Random java question was gotten: " + returnedQuestion);
        return returnedQuestion;
    }
}
