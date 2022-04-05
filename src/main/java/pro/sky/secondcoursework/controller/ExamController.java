package pro.sky.secondcoursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    Collection<Question> getQuestions(@RequestParam int amount) {
        return service.getQuestions(amount);
    }
}
