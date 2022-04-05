package pro.sky.secondcoursework.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.repository.QuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void shouldAddJavaQuestionByRepositoryWhenAddJavaQuestion() {
        service.add(ADDED);
        verify(questionRepository).add(ADDED);
    }

    @Test
    void shouldAddJavaQuestionByRepositoryWhenAddQuestionAndAnswerOnJava() {
        service.add(ADDED.getQuestion(), ADDED.getAnswer());
        verify(questionRepository).add(ADDED);
    }

    @Test
    void shouldRemoveJavaQuestionByRepositoryWhenRemoveJavaQuestion() {
        service.remove(REMOVED);
        verify(questionRepository).remove(REMOVED);
    }


    @Test
    void shouldReturnAllJavaQuestionsWhenGetAll() {
        List<Question> expected = QUESTIONS;
        when(questionRepository.getAll()).thenReturn(expected);

        List<Question> result = service.getAll();

        assertEquals(expected, result);
    }
}
