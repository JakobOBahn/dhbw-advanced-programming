package de.dhbw.course1.tdd;

import de.dhbw.commons.Logger;
import de.dhbw.course1.Course1Main;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ALL")
public class TddByExampleTest {

    private final Logger logger = new Logger(Course1Main.class);

    @BeforeAll
    public static void beforeAllTests() { /* global initialization */ }

    @BeforeEach
    public void beforeEachTests() { /* test-local initialization */ }

    @AfterEach
    public void afterEachTests() { /* test-local clean-up */ }

    @AfterAll
    public static void afterAllTests() { /* global clean-up */ }

    @Test
    public void givenWhenThen() {
        // given

        // when

        // then
    }

    @Test
    public void arrangeActAssert() {
        // arrange

        // act

        // assert
    }

    /*
     * ==========================================================
     *
     * Anwendungsfall (Beispiel):
     *
     * "Ein Zug kann sich in unterschiedlichen Zuständen befinden.
     *  Die Zug-Zustände weisen eine definierte Reihenfolge auf.
     *  Und das soll prüfbar sein!"
     *
     * ==========================================================
     */

    @Test
    public void redPhase() {
        // given
        TrainObserverInRedPhase observer = new TrainObserverInRedPhase();

        // when
        String nextState = observer.nextState("departed");

        // then
        assertEquals("riding", nextState);
    }

    @Test
    public void greenPhase() {
        // given
        TrainObserverInGreenPhase observer = new TrainObserverInGreenPhase();

        // when
        String nextState = observer.nextState("departed"); // fails for any other value!

        // then
        assertEquals("riding", nextState);
    }

    @Test
    public void firstRefactoring() {
        // given
        TrainObserverFirstRefactoring observer = new TrainObserverFirstRefactoring();

        // when
        String nextState = observer.nextState("departed"); // succeeds for 'known' values

        // then
        assertEquals("riding", nextState);
    }

    @Test
    public void secondRefactoring() {
        // given
        TrainObserverSecondRefactoring observer = new TrainObserverSecondRefactoring();

        // when
        String nextState = observer.nextState("departed", "teleport");

        // then
        assertEquals("arrived", nextState);
    }

}