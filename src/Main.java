import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BST binarySearchTree = new BST();
        String[] CompletePhrase = {};
        int WordAmount = 0;

        try {
            File obj = new File("Diccionario.txt");
            Scanner myReader = new Scanner(obj);
            int Counter = 0;
            while (myReader.hasNextLine()) {
                Counter++;
                String Data = myReader.nextLine();
                String[] DataSplit = Data.split(",");
                Association<Integer, String[]> traduccion = new Association<Integer, String[]>(Counter, DataSplit);
                binarySearchTree.insert(Counter, traduccion);
            }
            WordAmount = Counter;
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            File obj = new File("Texto.txt");
            Scanner myReader = new Scanner(obj);
            String Data = myReader.nextLine();
            Data = Data.replace(".", "");
            CompletePhrase = Data.split(" ");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
            System.exit(1);
        }

    }
}