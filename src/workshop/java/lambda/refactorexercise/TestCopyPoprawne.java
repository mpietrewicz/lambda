import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCopyPoprawne {

    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");

        target.delete();
        double copyTime1 = BeforeRefactor.fileCopyTime(source, target);

        target.delete();
        double copyTime2 = AfterRefactor.fileCopyTime(new FileCopy() {
            @Override
            public void copyOperation(File source, File target) throws IOException {
                Files.copy(source.toPath(), target.toPath());
            }
        }, source, target);

        target.delete();
        double copyTime3 = AfterRefactor.fileCopyTime((s,t)-> Files.copy(s.toPath(), t.toPath()),source, target);
        System.out.printf("%f%n%f%n%f%n",copyTime1,copyTime2, copyTime3);
    }

}


class BeforeRefactor {
    public static double fileCopyTime(File source, File target)
            throws IOException {
        long start = System.nanoTime();
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(target)) { int anotherByte;
            while ((anotherByte = in.read()) != -1) {
                out.write(anotherByte); }
        }
        long stop = System.nanoTime();
        return (stop - start) / 1e6; // czas w ms
    }
}


class AfterRefactor {
    public static double fileCopyTime(FileCopy fileCopy, File source, File target)
            throws IOException {
        long start = System.nanoTime();
        fileCopy.copyOperation(source, target);
        long stop = System.nanoTime();
        return (stop - start) / 1e6; // czas w ms
    }
}

interface FileCopy {
    void copyOperation(File source, File target) throws IOException;
}