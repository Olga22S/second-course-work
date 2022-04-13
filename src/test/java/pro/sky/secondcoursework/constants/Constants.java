package pro.sky.secondcoursework.constants;

import pro.sky.secondcoursework.model.Question;

import java.util.List;

public class Constants {

    public static final String QUESTION = "What is a Map?";
    public static final String ANSWER = "Data structure";
    public static final Question QUESTION_FIRST =
            new Question("What is a variable?", "Named memory area");
    public static final Question QUESTION_SECOND =
            new Question("What is an encapsulation?", "Hiding the implementation");

    public static final List<Question> QUESTIONS = List.of(
            new Question("What is a Spring?", "FrameWork"),
            new Question("What is a Map?", "Data structure"),
            new Question("What is a variable?", "Named memory area"));
}
