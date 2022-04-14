package pro.sky.secondcoursework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.sky.secondcoursework.controller.JavaQuestionController;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.service.QuestionService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pro.sky.secondcoursework.constants.Constants.ANSWER;
import static pro.sky.secondcoursework.constants.Constants.QUESTION;

@WebMvcTest(JavaQuestionController.class)
public class SecondCourseWorkApplicationWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("javaQuestionService")
    private QuestionService questionService;

    @Test
    public void saveQuestionTest() throws Exception {
        Question javaQuestion = new Question(QUESTION, ANSWER);
        when(questionService.add(anyString(), anyString())).thenReturn(javaQuestion);
        mockMvc.perform(
                        get("/java/add?question=What is a Map?&answer=Data structure"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.question").value(QUESTION),
                        jsonPath("$.answer").value(ANSWER)
                );
    }

    @Test
    public void removeQuestionTest() throws Exception {
        Question javaQuestion = new Question(QUESTION, ANSWER);
        when(questionService.remove(any(Question.class))).thenReturn(javaQuestion);
        mockMvc.perform(
                        get("/java/remove?question=What is a Map?&answer=Data structure"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.question").value(QUESTION),
                        jsonPath("$.answer").value(ANSWER)
                );
    }

    @Test
    public void getAllQuestionTest() throws Exception {
        List<Question> expected = List.of(new Question(QUESTION, ANSWER));
        when(questionService.getAll()).thenReturn(expected);
        mockMvc.perform(
                        get("/java"))
                .andDo(print())
                .andExpectAll(
                        content().contentType(MediaType.APPLICATION_JSON),
                        status().isOk()
                );
    }
}

//this.mockMvc.perform(get("/")).andExpect(cookie().value(COOKIE_NAME, "en-US"));
//        this.mockMvc.perform(get("/")).andExpect(cookie().value(COOKIE_NAME, equalTo("en-US")));
