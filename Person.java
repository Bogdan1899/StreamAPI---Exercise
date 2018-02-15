
public class Person {

    private String name;

    private int group;

    public Person(String name, int group) {
        this.setName(name);
        this.setGroup(group);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    private void setGroup(int group) {
        this.group = group;
    }
}
