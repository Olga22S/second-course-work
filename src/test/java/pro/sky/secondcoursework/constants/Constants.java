package pro.sky.secondcoursework.constants;

import pro.sky.secondcoursework.model.Question;

import java.util.Collection;
import java.util.List;

public class Constants {

    public static final Question REMOVED =
            new Question("What is a variable?", "Named memory area");
    public static final Question ADDED =
            new Question("What is an encapsulation?", "Hiding the implementation");

    public static final List<Question> QUESTIONS = List.of(
            new Question("What is a Spring?", "FrameWork"),
            new Question("What is a Map?", "Data structure"),
            new Question("What is a variable?", "Named memory area"));
}
