import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// PersonTest.java
public class PersonTest {
    public static void main(String[] args) {
        testSetAge();
        testFindByName();
        testFindByNameInvalidFormat();
        testClone();

        System.out.println("¡Todas las pruebas han sido superadas!");
    }

    /**
     * Prueba el método setAge para asegurar que lanza un error para edades negativas
     */
    public static void testSetAge() {
        Person person = new Person(1, "Juan Pérez", 30, "Desarrollador");

        try {
            person.setAge(-1);
            System.out.println("Prueba fallida: setAge debería lanzar una excepción para edad negativa");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba superada: setAge lanza correctamente una excepción para edad negativa");
        }
    }

    /**
     * Prueba el método findByName para asegurar que encuentra correctamente la Person
     */
    public static void testFindByName() {
        PersonsList list = new PersonsList();
        Person person1 = new Person(1, "Juan Pérez", 30, "Desarrollador");
        Person person2 = new Person(2, "Ana García", 25, "Diseñadora");

        list.addPerson(person1);
        list.addPerson(person2);

        try {
            Person found = list.findByName("Ana García");
            if (found == null || !found.equals(person2)) {
                System.out.println("Prueba fallida: findByName no devolvió la Person correcta");
                System.exit(1);
            }

            System.out.println("Prueba superada: findByName devolvió la Person correcta");
        } catch (Exception e) {
            System.out.println("Prueba fallida: findByName lanzó una excepción inesperada: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Prueba el método findByName para asegurar que lanza una excepción para nombres mal formateados
     */
    public static void testFindByNameInvalidFormat() {
        PersonsList list = new PersonsList();

        try {
            list.findByName("JuanPérez");
            System.out.println("Prueba fallida: findByName debería lanzar una excepción para nombre mal formateado");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba superada: findByName lanza correctamente una excepción para formato de nombre inválido");
        }
    }

    /**
     * Prueba el método clone para asegurar que crea una nueva Person con un nuevo ID
     */
    public static void testClone() {
        PersonsList list = new PersonsList();
        Person original = new Person(1, "Juan Pérez", 30, "Desarrollador");

        Person clone = list.clone(original);

        if (clone.getId() == original.getId()) {
            System.out.println("Prueba fallida: clone debería crear una Person con un nuevo ID");
            System.exit(1);
        }

        // Comprueba que las otras propiedades son las mismas
        if (!clone.getName().equals(original.getName()) ||
                clone.getAge() != original.getAge() ||
                !clone.getOccupation().equals(original.getOccupation())) {
            System.out.println("Prueba fallida: clone debería copiar todas las propiedades excepto ID");
            System.exit(1);
        }

        System.out.println("Prueba superada: clone crea una nueva Person con las mismas propiedades pero nuevo ID");
    }
}
