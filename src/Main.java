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
                Association<Integer, String[]> traduccion = new Association<Integer,String[]>(Counter, DataSplit);
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

        System.out.println("\nBienvenido al Traductor");

        boolean prin = false;
        a: while(prin == false){

            int numberlanguage = 0;
            String[] phrase = CompletePhrase;

            boolean var2 = false;
            while(var2 == false){
                System.out.println("\n\nIngrese la traduccion que desea:");
                System.out.println("1) Ingles");
                System.out.println("2) Español");
                System.out.println("3) Francés");
                System.out.println("4) Salir\n");

                try {

                    int Option = scanner.nextInt();

                    if(Option == 1){
                        numberlanguage = 0;
                        var2 = true;
                    }
                    else if(Option == 2){
                        numberlanguage = 1;
                        var2 = true;
                    }
                    else if(Option == 3){
                        numberlanguage = 2;
                        var2 = true;
                    }
                    else if(Option == 4){
                        System.out.println("Saliendo del Programa");
                        break a;
                    }
                    else{
                        System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    scanner.nextLine();
                }
            }

            System.out.println("\nLos valores de las llaves del arbol son:");
            binarySearchTree.inorder();
            System.out.println("\n");

            for(int i = 0; i < phrase.length; i++){

                String Word = phrase[i];
                int WordCount = 0;

                for(int j = 1; j <= WordAmount; j++) {
                    Node nodo = binarySearchTree.Search(binarySearchTree.getRoot(), j);
                    String[] Key = nodo.getTraduccion();
                    for(int k = 0; k < Key.length; k++){

                        String Traduction = Key[k];
                        if(Traduction.equalsIgnoreCase(Word)){
                            phrase[i] = Key[numberlanguage];
                        }
                        else{
                            WordCount++;
                        }
                    }
                }

                int Limit = WordAmount * 3;
                if(WordCount == Limit){
                    String NewWord = "";
                    if(Word.charAt(0) != '*' && Word.charAt(Word.length() - 1) != '*'){
                        for(int j = -1; j < (Word.length() + 1); j++){
                            if(j == -1 || j == Word.length()){
                                NewWord += "*";
                            }
                            else{
                                NewWord += Word.charAt(j);
                            }
                        }
                        phrase[i] = NewWord;
                    }
                }
            }

            String FinalPhrase = "";
            for(int i = 0; i < phrase.length; i++){
                FinalPhrase += phrase[i];
                FinalPhrase += " ";
            }
            System.out.println("La traduccion es: " + FinalPhrase);
        }
    }
}
