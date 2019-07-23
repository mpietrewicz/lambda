package workshop.java.lambda;

/*
    TODO a utwórz własny interfejs, metodęprzyjmującą ten interfejs jako parametr
    TODO b Wywołaj metodę:
    -z jawną implementacją
    -klasą anonimową
    -lambdą

    TODO c modyfikuj parametry / zwracany typ w definicji metody w interfejsie
 */
public class _II_ImplementacjeInterfejsu {

    public static void main(String[] args) {
        /*
            3
            Lambda_IIc przekazanie implementacji do metody - jawna implementacja
         */

        // jawna implementacja
        MyImplementation myImplementation = new MyImplementation();
        useMyInterfaceAsParam(myImplementation, "1", 2);

        useMyInterfaceAsParam(new MyImplementation(), "1", 2);


        /*
            4
            Lambda_IId przekazanie implementacji do metody - anonimowa implementacja
         */

        MyInterface anonymousImplAssignedToRef = new MyInterface() {
            @Override
            public String mojaMetoda(String s, int i) {
                return "Anonimowa implementacja przypisana do zmiennej: " + Integer.valueOf(s) + i;
            }
        };
        useMyInterfaceAsParam(anonymousImplAssignedToRef, "1", 2);

        useMyInterfaceAsParam(new MyInterface() {
            @Override
            public String mojaMetoda(String s, int i) {
                return "Anonimowa implementacja przekazana jako argument: " + s + i;
            }
        }, "1", 2);

        /*
            Lambda_IIe przekazanie implementacji do metody - lambda
         */

        MyInterface lambdaAssignedToVar = (s, i) -> "Lambda przypisana do zmiennej: " + (s + i);

        useMyInterfaceAsParam(lambdaAssignedToVar, "1", 2);

        useMyInterfaceAsParam((s, i) -> "Lambda: " + s + i, "1", 2);


    }


    /*
        2
        Metoda z parametrem o typie naszego interfejsu
     */

    static void useMyInterfaceAsParam(MyInterface myInterface, String s, int i) {
        System.out.println(myInterface.mojaMetoda(s, i));
    }

}


/*
    1
    Lambda_IIa interfejs i jego klasyczna implementacja
 */

@FunctionalInterface
interface MyInterface {
    String mojaMetoda(String s, int i);
}

class MyImplementation implements MyInterface {

    @Override
    public String mojaMetoda(String s, int i) {
        return "Jawna implementacja: " + s + i;
    }
}
