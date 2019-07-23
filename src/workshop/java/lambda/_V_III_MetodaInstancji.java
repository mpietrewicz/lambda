package workshop.java.lambda;
/*
    (obj, args) -> obj.instanceMethod(args)

                vs

    ObjectType::instanceMethod

    Przekazana jest instancja obiektu i wywoływana jest jedna z jego metod (opcjonalnie parametryzowana)

    Konwersja nie jest intuicyjna:
    - używamy typu (w przykładzie ObjectType) a nie instancji
    - w zapisie nie widać, że przekazujemy argumenty (jeśli metoda przyjmuje parametry)
*/
public class _V_III_MetodaInstancji {

    public static void main(String[] args) {
    /*
    3
    Przekaż do System.out.println wywołanie metody TriFunction
    implementacja - lambda

    4
    Przekaż do System.out.println wywołanie metody TriFunction
    implementacja - referencja do metody instancyjnej

    */

        TriFunction<Sum, String, String, Integer> triFunctionLambda = (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1);


        TriFunction<Sum, String, String, Integer> triFunctionRef=Sum::doSum;

        System.out.println(triFunctionLambda.apply(new Sum(),"10","20"));
        System.out.println(triFunctionRef.apply(new Sum(),"10","20"));


        /*

            5 zaobserwuj, jak uprościł się kod

            (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1)

            zastępujemy

            Sum::doSum


            6 - kto poskusi się o własny przykład? :)
        */
    }
}


/*
   1
   Utwórz interfejs TriFunction<T,U,V,R>,
   metoda apply zwraca R, przyjmuje parametry U, V, R

   2
   Utwórz klasę Sum z metodą doSum, metoda
   przyjmuje String, String
   zwraca Integer (suma)
*/


@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

class Sum {
    Integer doSum(String s1, String s2) throws NumberFormatException {
        return Integer.parseInt(s1) + Integer.parseInt(s1);
    }
}
