package workshop.java.lambda;

import java.util.function.*;

/*
    TODO zaimplementuj własne przykłady wykorzystujące gotow interfejsy funkcyjne
    (metoda i wywołanie z lambdą)
    - Predicate
    - Consumer
    - Supplier
    - Function
    - BiFunction

 */
public class _IV_GotoweInterfejsy {

    public static void main(String[] args) {

        int i = 0;

        /*

        lambdy do przykładów interfejsów

        */

        Predicate<String> predicate = s -> s.length() < 10;
        Predicate<String> predicateFirstCharInt = str -> {
            if (str.length() > 0) {
                String character = str.substring(0, 1);
                return character.matches("\\d");
            } else {
                return false;
            }
        };

        System.out.println(usePredicate(predicate, "200"));
        System.out.println(usePredicate(predicateFirstCharInt, "ccc"));

        Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumerWithHash = str -> System.out.println("# " + str);
        Consumer<Integer> consumerMath = value -> System.out.println(Math.abs(value));

        useConsumer(consumer, "Użycie konsumera");
        useConsumer(consumerWithHash, "test konsumera z hashem");
        useConsumer(consumerMath, -11);

        Supplier<String> supplier1 = () -> "abc".toUpperCase();

        System.out.println(useSupplier(supplier1));

        Function<String, Integer> function = s -> Integer.parseInt(s) * 10;

        System.out.println(useFunction(function, "100"));

        BiFunction<String, String, Integer> biFunction = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);

        System.out.println(useBiFunction(biFunction, "5", "6"));

    }

    /*

    Przykładowe, podstawowe 'gotowce'

    Predicate, Consumer, Supplier, Function, BiFunction

 */
    static boolean usePredicate(Predicate<String> p, String value) {
        return p.test(value);
    }

    static void useConsumer(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }

    static void useConsumer(Consumer<Integer> consumer, int value) {
        consumer.accept(value);
    }

    static String useSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    static Integer useFunction(Function<String, Integer> function, String value) {
        return function.apply(value);
    }

    static Integer useBiFunction(BiFunction<String, String, Integer> function, String a, String b) {
        return function.apply(a, b);
    }

}
