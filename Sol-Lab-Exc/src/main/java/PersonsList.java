import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> people;
    private int nextId;

    /**
     * Constructor para PersonsList
     */
    public PersonsList() {
        this.people = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Añade una persona a la lista
     * @param person la persona a añadir
     */
    public void addPerson(Person person) {
        people.add(person);
        if (person.getId() >= nextId) {
            nextId = person.getId() + 1;
        }
    }

    /**
     * Busca una persona por su nombre
     * @param name el nombre a buscar en formato "nombre apellido"
     * @return la persona con el nombre coincidente
     * @throws IllegalArgumentException si el nombre no está correctamente formateado
     * @throws RuntimeException si no se encuentra ninguna persona con el nombre dado
     */
    public Person findByName(String name) {
        // Comprueba si el nombre está correctamente formateado (nombre apellido)
        // Nueva expresión regular que acepta letras, acentos, espacios y otros caracteres comunes en nombres
        if (!Pattern.matches("^[A-Za-zÁáÉéÍíÓóÚúÜüÑñ]+ [A-Za-zÁáÉéÍíÓóÚúÜüÑñ ]+$", name)) {
            throw new IllegalArgumentException("El nombre debe estar en formato 'nombre apellido'");
        }

        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new RuntimeException("No se encontró ninguna persona con el nombre: " + name);
    }

    /**
     * Crea un clon de una persona con un nuevo ID
     * @param person la persona a clonar
     * @return una nueva Person con las mismas propiedades pero un nuevo ID
     */
    public Person clone(Person person) {
        Person newPerson = new Person(
                nextId++,
                person.getName(),
                person.getAge(),
                person.getOccupation()
        );
        return newPerson;
    }

    /**
     * Escribe la información de una persona en un archivo
     * @param person la persona cuya información se va a escribir
     * @throws IOException si hay un error al escribir en el archivo
     */
    public void writeToFile(Person person) {
        String fileName = "persona_" + person.getId() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de personas
     * @return la lista de personas
     */
    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }
}