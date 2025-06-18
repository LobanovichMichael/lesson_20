package org.example.lesson_20;

public class NamesData {
    public static String firstName;
    public static String secondName;

    public static int firstScore;
    public static int secondScore;

    public static void compareNames(String firstName, String secondName) {
        if (NamesData.firstName == null || NamesData.secondName == null) return;
        if (!NamesData.firstName.equals(firstName) || !NamesData.secondName.equals(secondName)) {
            NamesData.firstScore = 0;
            NamesData.secondScore = 0;
        }
    }
}
