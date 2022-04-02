package pro.sky.secondcoursework.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.repository.QuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pro.sky.secondcoursework.constants.Constants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private JavaQuestionService service;

    @Test
    void add() {
        service.add(ADDED);
        verify(questionRepository).add(ADDED);
    }

    @Test
    void addByName() {
        service.add("What is encapsulation?", "Hiding the implementation");
        verify(questionRepository).add(ADDED);
    }

    @Test
    void remove() {
        service.remove(REMOVED);
        verify(questionRepository).remove(REMOVED);
    }

    @Test
    void getAll() {
        Collection<Question> expected = QUESTIONS;
        when(questionRepository.getAll()).thenReturn(expected);

        Collection<Question> result = service.getAll();

        assertTrue(expected.containsAll(result));
    }
}
