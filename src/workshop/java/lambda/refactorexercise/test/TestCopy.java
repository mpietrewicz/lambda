package workshop.java.lambda.refactorexercise.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {

    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");
        AfterRefactor.fileCopyTime(source, null, "start test", (src, str, i) -> {

            System.out.println(source);
            System.out.println(str);
            System.out.println(target);
            System.out.println(str);
            System.out.println(i);

        });

    }

}


class AfterRefactor {
    public static double fileCopyTime(File source, File target, String startText, newCopyInterface newCopyInterface)
            throws IOException {
        long start = System.nanoTime();
        newCopyInterface.copy(source, startText, 1);
        long stop = System.nanoTime();
        return (stop - start) / 1e6; // czas w ms
    }
}


/*
    TODO 1 delegacja - kod kopiowania z metody fileCopyTime przenieść do osobnej klasy
    operację kopiowania reprezentuje interfejs (dodatkowy parametr w metodzie fileCopyTime
    Poszczególne implementory, zawierają różną logikę kopiowania - zaprezentowana i
    Files.copy(source.toPath(), target.toPath())
  */

interface copyInterface {
    void copy(File source, File target) throws IOException;
}

interface newCopyInterface {
    void copy(File source, String startText, int index);
}

/*
    TODO 2 zamiast konkretnych klas, użycie anonimowych implementacji
 */


/*
    TODO 3 zamiast konkretnych klas / anonimowych implementacji. użycie lambd
 */
