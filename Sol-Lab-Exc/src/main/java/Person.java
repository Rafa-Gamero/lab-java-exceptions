public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;


    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getOccupation() {
        return occupation;
    }


    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        return occupation.equals(person.occupation);
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", edad=" + age +
                ", ocupación='" + occupation + '\'' +
                '}';
    }
}