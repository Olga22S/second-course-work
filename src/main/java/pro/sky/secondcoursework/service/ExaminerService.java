package pro.sky.secondcoursework.service;

import pro.sky.secondcoursework.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
