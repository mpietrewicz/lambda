package workshop.java.lambda;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToLongFunction;

public class _III_KontekstUzyciaLambdy {

    public static void main(String[] args) {
        /*
            Wyrażenie lambda nie posiada konkretnego typu, a to oznacza, że nie możee występować
            'samodzielnie' (Java jest językiem ściśle ́typowanym)

            Typ wyrażenia lambda jest zawsze wnioskowany przez kompilator na podstawie kontekstu jego użycia –
           jest on okreś́lony przez interfejs funkcyjny
        */

        System.out.println(concat((x, y) -> x + y, "10","20"));
        System.out.println(add((x, y) -> x + y, "10","20"));
        Long longValue = getLong(i -> i, 5);
        System.out.println(longValue.floatValue());

    }


       /*
        Przykłady na kontekst użycia tej samej labdy
     */

    static String concat(BinaryOperator<String> binaryOperator, String s1, String s2) {
        return binaryOperator.apply(s1, s2);
    }

    static Integer add(IntBinaryOperator intBinaryOperator, String s1, String s2) {
        return intBinaryOperator.applyAsInt(Integer.valueOf(s1), Integer.valueOf(s2));
    }

    static Long getLong(IntToLongFunction intToLongFunction, int value) {
        return intToLongFunction.applyAsLong(value);
    }
}
