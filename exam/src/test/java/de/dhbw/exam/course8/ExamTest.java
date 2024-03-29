package de.dhbw.exam.course8;

import main.java.de.dhbw.commons.Logger;
import de.dhbw.exam.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static de.dhbw.exam.Answers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Course 8 ExamTests")
public class ExamTest {

    private final Logger logger = new Logger(ExamTest.class);

    private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
    """
    Q1: Dies ist eine DUMMY Frage?
    
    A. Dies ist eine DUMMY Antwort!
    """
    )
    // Please give your answer here:
    @ValueSource(strings = {"A"}) // TODO: COURSE 8 -> REPLACE CORRECT ANSWER WITH "?" BEFORE COURSE DAY
    @ParameterizedTest
    public void question1(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q1);

        // when
        boolean isCorrect = correctAnswer.getLetter().equals(studentAnswer);

        // then
        assertTrue(isCorrect, butMaybeWrong(Q1, studentAnswer));
    }

}