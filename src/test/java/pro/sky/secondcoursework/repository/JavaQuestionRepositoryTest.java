package pro.sky.secondcoursework.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.secondcoursework.exeption.QuestionExistsException;
import pro.sky.secondcoursework.exeption.QuestionNotFoundException;
import pro.sky.secondcoursework.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.secondcoursework.constants.Constants.QUESTION_FIRST;
import static pro.sky.secondcoursework.constants.Constants.QUESTION_SECOND;

class JavaQuestionRepositoryTest {

    private JavaQuestionRepository questionRepository;

    @BeforeEach
    public void setUp() {
        questionRepository = new JavaQuestionRepository();
        questionRepository.add(QUESTION_FIRST);
    }

    @Test
    void shouldAddJavaQuestionWhenAddJavaQuestion() {
        assertEquals(questionRepository.getAll().size(), 1);
        questionRepository.add(QUESTION_SECOND);
        assertEquals(questionRepository.getAll().size(), 2);
    }

    @Test
    void shouldRemoveJavaQuestionWhenRemoveJavaQuestion() {
        assertEquals(questionRepository.getAll().size(), 1);
        questionRepository.remove(QUESTION_FIRST);
        assertEquals(questionRepository.getAll().size(), 0);
    }

    @Test
    void shouldThrowQuestionExistExceptionWhenAddAlreadyExistQuestion() {
        assertThrows(QuestionExistsException.class, () -> questionRepository.add(QUESTION_FIRST));
    }

    @Test
    void shouldThrowQuestionNotFoundExceptionWhenRemoveNotExistQuestion() {
        assertThrows(QuestionNotFoundException.class, () -> questionRepository.remove(QUESTION_SECOND));
    }

    @Test
    void shouldReturnAllJavaQuestionsWhenGetAll() {
        List<Question> expected = List.of(QUESTION_FIRST);

        List<Question> result = questionRepository.getAll();

        assertEquals(expected, result);
    }
}
