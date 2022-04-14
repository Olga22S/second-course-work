package pro.sky.secondcoursework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import pro.sky.secondcoursework.controller.ExamController;
import pro.sky.secondcoursework.controller.JavaQuestionController;
import pro.sky.secondcoursework.controller.MathQuestionController;
import pro.sky.secondcoursework.model.Question;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecondCourseWorkApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private JavaQuestionController javaController;

    @Autowired
    private MathQuestionController mathController;

    @Autowired
    private ExamController examController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoadsJavaController() {
        assertThat(javaController).isNotNull();
    }

    @Test
    void contextLoadsMathController() {
        assertThat(mathController).isNotNull();
    }

    @Test
    void contextLoadsExamController() {
        assertThat(examController).isNotNull();
    }

    @Test
    public void testJavaControllerAdd() {
        Question question = new Question("What is a Enum?", "A set of constants");

        assertEquals(restTemplate.getForObject(
                "http://localhost:" + port + "/exam/java/add?question=What is a Enum?&answer=A set of constants",
                Question.class), question);
    }

    @Test
    public void testJavaControllerRemove() {
        Question question = new Question("What is a Map?", "Data structure");

        assertEquals(restTemplate.getForObject(
                "http://localhost:" + port + "/exam/java/remove?question=What is a Map?&answer=Data structure",
                Question.class), question);
    }

    @Test
    public void testGetAllJavaController() {
        assertNotNull(restTemplate.getForObject("http://localhost:" + port + "/exam/java/", Collection.class));
    }

    @Test
    public void shouldReturnBAD_REQUEST_WhenAddAlreadyExistQuestion() {
        ResponseEntity<Question> response =
                restTemplate.getForEntity("http://localhost:" + port
                        + "/exam/java/add?question=What is a Map?&answer=Data structure", Question.class);

        assertEquals(response.getStatusCode(), BAD_REQUEST);
    }
}
