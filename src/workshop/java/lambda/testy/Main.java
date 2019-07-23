package workshop.java.lambda.testy;

public class Main {

    public static void main(String[] args) {
        useMyInterface(new MyImplementation(), 10);

        // TODO 2 anoniomowa implementacja
        useMyInterface(new MyInterface() {
            @Override
            public void go(int i, String str) {
                System.out.printf("Anonimowa implementacja, wartość i: %d%n", i);
                System.out.println("test 2");
            }
        }, 44);

        // TODO 3 lambda
        useMyInterface((i, str) -> System.out.println("Lambda"), 99);

    }



    static void useMyInterface(MyInterface myInterface, int i) {
        myInterface.go(i, "test 1");
    }

}

interface MyInterface {
    void go(int i, String str);
}

// TODO 1 javna implementacja

class MyImplementation implements MyInterface {

    @Override
    public void go(int i, String str) {
        System.out.printf("Jawna implementacja, wartość i: %d%n", i);
        System.out.println(str);
    }
}