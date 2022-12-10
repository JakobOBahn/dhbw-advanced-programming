package de.dhbw.course1.theory;

import de.dhbw.commons.Logger;
import de.dhbw.course1.theory.objectcontract.Passenger;
import de.dhbw.course1.theory.objectcontract.Train;
import de.dhbw.course1.theory.refsemantics.Account;
import de.dhbw.course1.theory.refsemantics.AccountManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TheoryTest {

    private final Logger logger = new Logger(TheoryTest.class);

    // --------------------------------------------------------------------------------
    //                               Reference Semantics
    //
    //                               +---------+
    //  Variable: account -----------> Account |
    //                               | ....... |
    //                               | amount  |
    //                               +---------+
    // --------------------------------------------------------------------------------

    @Test
    @DisplayName(
            """
            Reference Semantics 1:
             Pass by Value: In the pass by value concept, the method is called by passing a value. The argument
             is a copy of the original one. This is called 'pass by value'. It does not affect the original parameter.
            """
    )
    //tag::ref-semantics-1[]
    public void canDemonstrateReferenceSemantics1() {
        // given - a primitive value
        AccountManager manager = new AccountManager();

        int amount = 2100;
        System.out.println("Amount before deposit : " + amount);

        // when
        manager.depositV1(amount, 500);

        // then
        System.out.println("Amount after deposit  : " + amount);
    }
    //end::ref-semantics-1[]

    @Test
    @DisplayName(
            """
            Reference Semantics 2:
             Pass by Reference: In the pass by reference concept, the method is called using an alias or reference
             of the actual parameter. This is called pass by reference. It forwards the unique identifier of the
             object to the method. If we made changes to the parameter's instance member, it would affect the original
             value. Java does not support pass by reference concept!
            """
    )
    //tag::ref-semantics-2[]
    public void canDemonstrateReferenceSemantics2() {
        // given
        AccountManager manager = new AccountManager();
        Account account = new Account();

        System.out.println("Amount before deposit : " + account.getAmount());

        // when
        manager.depositV2(account, 750);

        // then
        System.out.println("Amount after deposit  : " + account.getAmount());
    }
    //end::ref-semantics-2[]

    @Test
    @DisplayName(
            """
            Reference Semantics 3:
             Although the argument variable is copied, just the reference ist copied. The object that is referenced
             is still the same and thus changed here!
            """
    )
    //tag::ref-semantics-3[]
    public void canDemonstrateReferenceSemantics3() {
        // given
        AccountManager manager = new AccountManager();
        Account account = new Account(1000);

        System.out.println("Amount before deposit : " + account.getAmount());

        // when
        manager.depositV3(account, 300);

        // then
        System.out.println("Amount after deposit  : " + account.getAmount());
    }
    //end::ref-semantics-3[]

    // --------------------------------------------------------------------------------
    //                               Object Contract
    // --------------------------------------------------------------------------------

    @Test
    public void canCommitEqualInstances() {
        // given
        Train train1 = new Train("RB-10");
        Train train2 = new Train("RB-10");

        // when
        boolean areEqual = train1.equals(train2);

        // then
        assertTrue(areEqual);
        logger.log(String.format("%s == %s", train1.hashCode(), train2.hashCode()));
    }

    @Test
    public void cannotCommitEqualInstances() {
        // given
        Passenger passenger1 = new Passenger("Max Mustermann");
        Passenger passenger2 = new Passenger("Max Mustermann");

        // when
        boolean areEqual = passenger1.equals(passenger2);

        // then
        assertFalse(areEqual);
        logger.log(String.format("%s != %s", passenger1.hashCode(), passenger2.hashCode()));
    }

}
