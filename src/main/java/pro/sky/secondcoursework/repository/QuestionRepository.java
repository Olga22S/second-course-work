package pro.sky.secondcoursework.repository;

import pro.sky.secondcoursework.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    List<Question> getAll();
}
