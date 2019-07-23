package workshop.java.lambda.testy;

public class Main {

    public static void main(String[] args) {
        useMyInterface(new MyImplementation(), 10);

        // TODO 2 anoniomowa implementacja
        useMyInterface(new MyInterface() {
            @Override
            public void go(int i) {
                System.out.printf("Anonimowa implementacja, wartość i: %d%n", i);
            }
        }, 44);

        // TODO 3 lambda
        useMyInterface(inter -> System.out.printf("Lambda, wartość i: %d%n", inter), 99);

    }



    static void useMyInterface(MyInterface myInterface, int i) {
        myInterface.go(i);
    }

}

interface MyInterface {
    void go(int i);
}

// TODO 1 javna implementacja

class MyImplementation implements MyInterface {

    @Override
    public void go(int i) {
        System.out.printf("Jawna implementacja, wartość i: %d%n", i);
    }
}