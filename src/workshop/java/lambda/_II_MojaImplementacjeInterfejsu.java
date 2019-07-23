package workshop.java.lambda;

import java.util.Arrays;
import java.util.List;

/*
    TODO a utwórz własny interfejs, metodęprzyjmującą ten interfejs jako parametr
    TODO b Wywołaj metodę:
    -z jawną implementacją
    -klasą anonimową
    -lambdą

    TODO c modyfikuj parametry / zwracany typ w definicji metody w interfejsie
 */
public class _II_MojaImplementacjeInterfejsu {

    public static void main(String[] args) {

        List<String> listaOsob = Arrays.asList("Marek", "Jan", "Anna");

        /*
            3
            Lambda_IIc przekazanie implementacji do metody - jawna implementacja
         */
        // jawna implementacja
        Szkola szkola = new Szkola();
        wykorzystajPrezentacje(szkola, "Prezentacja jawnej implementacji", listaOsob);
        wykorzystajPrezentacje(new Szkola(), "Prezentacja jawnej implementacji (new Szkola())", listaOsob);

        /*
            4
            Lambda_IId przekazanie implementacji do metody - anonimowa implementacja
         */
        Prezentacja prezentacjaAnonimowa = new Prezentacja() {
            @Override
            public String prezentujListe(String nazwaPrezentacji, List<String> lista) {
                return "Prezentacja anonimowa (nazwa: " +nazwaPrezentacji +"): " +lista;
            }
        };
        wykorzystajPrezentacje(prezentacjaAnonimowa, "anonim", listaOsob);
        wykorzystajPrezentacje(new Prezentacja() {
            @Override
            public String prezentujListe(String nazwaPrezentacji, List<String> lista) {
                return "Prezentacja anonimowa (nazwa: " +nazwaPrezentacji +"): " +lista;
            }
        }, "anonim ad-hoc", listaOsob);

        /*
            Lambda_IIe przekazanie implementacji do metody - lambda
         */
        wykorzystajPrezentacje((n, l) -> "Prezentacja LAMBDA -> " + n + ", lista: " + l, "lambda 1", listaOsob);
        Prezentacja lambda = (n, l) -> "Prezentacja LAMBDA z pola -> " + n + ", lista: " + l;
        wykorzystajPrezentacje(lambda, "lambda 2", listaOsob);


    }


    /*
        2
        Metoda z parametrem o typie naszego interfejsu
     */
    static void wykorzystajPrezentacje(Prezentacja prezentacja, String nazwa, List<String> lista) {
        System.out.println(prezentacja.prezentujListe(nazwa, lista));
    }


}


/*
    1
    Lambda_IIa interfejs i jego klasyczna implementacja
 */

@FunctionalInterface
interface Prezentacja {

    String prezentujListe(String nazwaPrezentacji, List<String> lista);

}

class Szkola implements Prezentacja {

    @Override
    public String prezentujListe(String nazwaPrezentacji, List<String> lista) {
        return "Prezentacja: " +nazwaPrezentacji +": " +lista;
    }

}