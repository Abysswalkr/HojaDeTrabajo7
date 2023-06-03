import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;

/**
 * La clase JUnitTest contiene pruebas unitarias para la clase BST.
 */
public class JUnitTest {

    BST bst = new BST();

    /**
     * Prueba el método insertar de la clase BST.
     */
    @Test
    public void insertar(){
        String[] lista = {"HOLA"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        bst.insert(1, association);
        Node node = bst.Search(bst.getRoot(), 1);

        assertEquals(lista, node.getTraduccion());//Se verifica si la lista que regresa es la mismas
    }

    /**
     * Prueba el método buscar de la clase BST.
     */
    @Test
    public void buscar(){
        String[] lista = {"HOLA", "A", "TODOS"};
        Association<Integer, String[]> association = new Association<Integer,String[]>(1, lista);
        bst.insert(1, association);
        Node node = bst.Search(bst.getRoot(), 1);

        assertEquals(association, node.getTraductions());//Se verifica si la association que regresa es la mismas
    }
}


