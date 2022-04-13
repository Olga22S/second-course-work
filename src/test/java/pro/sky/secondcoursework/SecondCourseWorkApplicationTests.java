package pro.sky.secondcoursework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pro.sky.secondcoursework.controller.ExamController;
import pro.sky.secondcoursework.controller.JavaQuestionController;
import pro.sky.secondcoursework.controller.MathQuestionController;

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
        Assertions.assertThat(javaController).isNotNull();
    }

    @Test
    void contextLoadsMathController() {
        Assertions.assertThat(mathController).isNotNull();
    }

    @Test
    void contextLoadsExamController() {
        Assertions.assertThat(examController).isNotNull();
    }
}
