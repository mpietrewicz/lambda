package workshop.java.lambda.refactorexercise.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {

    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");
        System.out.println(AfterRefactor.fileCopyTime(source, target, (s, t) -> {
            try (FileInputStream in = new FileInputStream(s);
                 FileOutputStream out = new FileOutputStream(t)) { int anotherByte;
                while ((anotherByte = in.read()) != -1) {
                    out.write(anotherByte); }
            }
        }));

    }

}


class AfterRefactor {
    public static double fileCopyTime(File source, File target, copyInterface copyInterface)
            throws IOException {
        long start = System.nanoTime();
        copyInterface.copy(source, target);
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


/*
    TODO 2 zamiast konkretnych klas, użycie anonimowych implementacji
 */


/*
    TODO 3 zamiast konkretnych klas / anonimowych implementacji. użycie lambd
 */