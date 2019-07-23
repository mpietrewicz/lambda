package workshop.java.lambda;

import java.util.function.Consumer;

/*

    (args) -> obj.instanceMethod(args)

                vs

    obj::instanceMethod

    Uzyta jest, zdefiniowana wcześniej instancja obiektu.
    jeśli przekazane są parametry (opcja), przekazywane są do metody

    TODO zaimplementuj własne rozwiązanie, analogicnze do przykładu

 */
public class _V_IV_MetodaInstancji {

    public static void main(String[] args) {
        /*
              4 wywołaj repair, użyj anonimowej implementacji

              5 wywołaj repair, użyj lambdy

              6 wywołaj repair, użyj referencji

           */


        Mechanic mechanic = new Mechanic();
        Car car = new Car(123);


        // anonymous
        repair(car, new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                mechanic.fix(car);
            }
        });

        // lambda
        repair(car, c -> mechanic.fix(c));


        // reference
        repair(car, mechanic::fix);

    }

    /*
    3 zdefiniuj statyczną metodę void repair (Car car, Consumer<Car> consumer)
        W metodzie wywołaj metodę accept na consumer
     */
    static void repair(Car car, Consumer<Car> consumer) {
        consumer.accept(car);
    }
}

/*

    1 zdefiniuj klasę Car z polem id: int

    2 zdefiniuj klasę Mechanic z metodą fix (void, jako prametr przyjmuje Car)

 */


class Car {
    private int id;

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Mechanic {
    public void fix(Car c) {
        System.out.printf("Fixing car %d", c.getId());
    }
}

