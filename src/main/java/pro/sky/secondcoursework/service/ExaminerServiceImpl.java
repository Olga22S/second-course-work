package pro.sky.secondcoursework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> services;
    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);
    private final Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> services) {
        this.services = services;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        logger.info("Generating list of all subjects questions...");
        Set<Question> questions = new HashSet<>();
        int serviceIndex;
        while (amount > 0) {
            serviceIndex = random.nextInt(services.size());
            if (questions.add(services.get(serviceIndex).getRandomQuestion())) {
                amount--;
            }
        }
        logger.info("List of questions was successfully generated!");
        return questions;
    }
}
