package pro.sky.secondcoursework.constants;

import pro.sky.secondcoursework.model.Question;

import java.util.Collection;
import java.util.List;

public class Constants {

    public static final Question REMOVED =
            new Question("What is variable?", "Named memory area");
    public static final Question ADDED =
            new Question("What is encapsulation?", "Hiding the implementation");

    public static final Collection<Question> QUESTIONS = List.of(
            new Question("What is Spring?", "FrameWork"),
            new Question("What is Map?", "Data structure"),
            new Question("What is variable?", "Named memory area"));
}
