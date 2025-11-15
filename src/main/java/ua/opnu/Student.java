package ua.opnu;


import java.util.Arrays;


public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int[] marks;


    public Student(String firstName, String lastName, String group, int[] marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.marks = marks == null ? new int[0] : marks.clone();
    }


    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }


    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }


    public int[] getMarks() { return marks.clone(); }
    public void setMarks(int[] marks) { this.marks = marks == null ? new int[0] : marks.clone(); }


    public boolean hasFailingMarks() {
        for (int m : marks) if (m < 60) return true;
        return false;
    }


    public String getFullName() {
        return (lastName == null ? "" : lastName + " ") + (firstName == null ? "" : firstName);
    }


    @Override
    public String toString() {
        return String.format("%s %s (group: %s) marks=%s",
                lastName, firstName, group, Arrays.toString(marks));
    }
}