package businessLogic;

import dataModels.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void add() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("5X^7 +2X^6 -3X^5 +2X");
        p2=new Polynomial("5X^7 -2X^6 -7X^5 -9");
        assertEquals(Operations.add(p1,p2).toString()," 10.0X^7 -10.0X^5 +2.0X -9.0");

    }

    @Test
    void substract() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("5X^7 +2X^6 -3X^5 +2X");
        p2=new Polynomial("5X^7 -2X^6 -7X^5 -9");
        assertEquals(Operations.substract(p1,p2).toString()," 4.0X^6 +4.0X^5 +2.0X +9.0");
    }

    @Test
    void multiply() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("3X +2");
        p2=new Polynomial("5X^3 -9X +2");
        assertEquals(Operations.multiply(p1,p2).toString()," 15.0X^4 +10.0X^3 -27.0X^2 -12.0X +4.0");
    }

    @Test
    void derivative() {
        Polynomial p =new Polynomial("8X^4 -X +2");
        assertEquals(Operations.derivative(p).toString()," 32.0X^3 -1.0");
    }

    @Test
    void division() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("21X^3 -23X^2 -20X +11");
        p2=new Polynomial("3X^2 -5X +1");
        assertEquals(Operations.division(p1,p2)[0].toString()," 7.0X +4.0");
        assertEquals(Operations.division(p1,p2)[1].toString()," -7.0X +7.0");
    }
    @Test
    void division1() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial();
        p2=new Polynomial("3X^2 -5X +1");
        assertEquals(Operations.division(p1,p2),null);

    }
    @Test
    void division2() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("X+6");
        p2=new Polynomial("0");
        assertEquals(Operations.division(p1,p2),null);

    }
    @Test
    void division3() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial("X+6");
        p2=new Polynomial("6X^2");
        assertEquals(Operations.division(p1,p2),null);

    }
    void division4() {
        Polynomial p1;
        Polynomial p2;
        p1=new Polynomial();
        p2=new Polynomial();
        assertEquals(Operations.division(p1,p2),null);

    }

    @Test
    void integral() {
        Polynomial p =new Polynomial("8X^4 -X +2");
        assertEquals(Operations.integral(p).toString()," 1.6X^5 -0.5X^2 +2.0X");
    }
}