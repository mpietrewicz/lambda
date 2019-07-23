package workshop.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
    (args) -> Class.staticMethod(args)

                vs

    Class::staticMethod

*/
public class _V_II_StatycznaMetoda {

    public static void main(String[] args) {
        // Wywołanie lambda / referencja

        // list
        List<Integer> list = Arrays.asList(120,15,5,10,13,25,410);
        // lambda
        List<Integer> filteredByLambda = Numbers.findNumbers(list, i -> Numbers.isLessThan20(i));

        // method reference
        List<Integer> filteredByReference = Numbers.findNumbers(list, Numbers::isLessThan20);

        System.out.println(filteredByLambda.equals(filteredByReference));

    }
}

// Klasa + statyczna metoda

class Numbers {
    public static boolean isLessThan20(int i) {
        return i < 20;
    }

    public static List<Integer> findNumbers(List<Integer> l, Predicate<Integer> p) {
        List<Integer> values = new ArrayList<>();

        for (Integer i : l) {
            if (p.test(i)) {
                values.add(i);
            }
        }
        return values;
    }
}