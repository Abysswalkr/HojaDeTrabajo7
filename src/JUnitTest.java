import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;

public class JUnitTest {

    BST bst = new BST();

    @Test
    public void insertar(){
        String[] lista = {"HOLA"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        bst.insert(1, association);
        Node node = bst.Search(bst.getRoot(), 1);

        assertEquals(lista, node.getTraduccion());//Se verifica si la lista que regresa es la mismas
    }

    @Test
    public void buscar(){
        String[] lista = {"HOLA", "A", "TODOS"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        bst.insert(1, association);
        Node node = bst.Search(bst.getRoot(), 1);

        assertEquals(association, node.getTraductions());//Se verifica si la association que regresa es la mismas
    }
}


