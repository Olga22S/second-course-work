package pro.sky.secondcoursework.repository;

import org.springframework.stereotype.Repository;
import pro.sky.secondcoursework.exeption.QuestionExistsException;
import pro.sky.secondcoursework.exeption.QuestionNotFoundException;
import pro.sky.secondcoursework.model.Question;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionExistsException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("What is a Spring?", "FrameWork"));
        questions.add(new Question("What is a Map?", "Data structure"));
        questions.add(new Question("What is  a variable?", "Named memory area"));
        questions.add(new Question("What is an encapsulation?", "Hiding the implementation"));
        questions.add(new Question("What is a recurse?", "Droch"));
    }
}
