package workshop.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    (args) -> new ClassName(args)


              vs

    ClassName::new

    Referencja do konstruktora jest podobna do referencji do statycznej metody,
    zamiast nazwy metody używamy 'new'.

    Jeśli konstruktor nie przyjmuje argumentów - lambda reprezentuje Supplier
                                         1 arg - lambda reprezentuje Funcition
                                         2 arg - lambda reprezentuje BiFunction
                                        >2 arg - definiujemy własny @FunctionalInterface
 */
public class _V_V_Konstruktor {

    public static void main(String[] args) {
        /*
            referencje do konstruktora -  użycie Supplier

       */


        // anonymous class
        Supplier<List<String>> anonymousSupplier = new Supplier() {
            public List<String> get() {
                return new ArrayList<String>();
            }
        };
        List<String> l = anonymousSupplier.get();

        // lambda expression
        Supplier<List<String>> lambdaSupplier = () -> new ArrayList<String>();
        l = lambdaSupplier.get();

        // method reference
        Supplier<List<String>> constructorRefSupplier = ArrayList::new;
        l = constructorRefSupplier.get();



        /*
            referencje do konstruktora -  użycie Function
        */


        // anonymous class
        Function<String, Integer> f = new Function<String, Integer>() {
            public Integer apply(String s) {
                return new Integer(s);
            }
        };

        Integer i = f.apply("100");
        System.out.println(i);

        // lambda expression
        Function<String, Integer> f1=s->new Integer(s);
        i=f1.apply("100");
        System.out.println(i);

        // method reference
        Function<String, Integer> f2=Integer::new;
        i=f2.apply("100");
        System.out.println(i);

            /*
        referencje do konstruktora -  użycie BiFunction
        Utwórz obiekt Locale z wartości lang, country

     */


        // anonymous class en_AU)
        BiFunction<String, String, Locale> bf = new BiFunction<String, String, Locale>() {
            public Locale apply(String lang, String country) {
                return new Locale(lang, country);
            }
        };
        Locale loc = bf.apply("en", "AU");
        System.out.println(loc.toString());
        // lambda expression en_US
        BiFunction<String, String, Locale> bf1 = (lang, country) -> new Locale(lang, country);
        loc =bf1.apply("en","UK");
        System.out.println(loc.toString());

        // method reference (en_UK)
        BiFunction<String, String, Locale> bf2 = Locale::new;
        loc =bf2.apply("en","US");
        System.out.println(loc.toString());
    }



}

