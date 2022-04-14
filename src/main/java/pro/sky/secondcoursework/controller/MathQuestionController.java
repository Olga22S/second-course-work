package pro.sky.secondcoursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.secondcoursework.aspect.LogExecutionTime;
import pro.sky.secondcoursework.model.Question;
import pro.sky.secondcoursework.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @LogExecutionTime
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @LogExecutionTime
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @LogExecutionTime
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

