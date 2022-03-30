package pro.sky.secondcoursework.repository;

import org.springframework.stereotype.Repository;
import pro.sky.secondcoursework.exeption.AlreadyExistQuestionException;
import pro.sky.secondcoursework.exeption.NotFoundQuestionException;
import pro.sky.secondcoursework.model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    public JavaQuestionRepository() {
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new AlreadyExistQuestionException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new NotFoundQuestionException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("What is Spring?", "FrameWork"));
        questions.add(new Question("What is Map?", "Data structure"));
        questions.add(new Question("What is variable?", "Named memory area"));
        questions.add(new Question("What is encapsulation?", "Hiding the implementation"));
        questions.add(new Question("What is recurse?", "Droch"));
    }
}
