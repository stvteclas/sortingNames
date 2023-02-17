package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    /*
        Using first_names.txt (text file containing over five-thousand first names), begin by sorting it into alphabetical order. Then workout the alphabetical value for each name, multiply this value by its alphabetical position to obtain a name score.

        Example: assuming sorted and ANA to be the 2nd name in the list it is worth: 1+14+1. So, the score would be 2*16 = 32.

        What is the total of all the name scores in the file?

        @param string
     *            the name to get the value of
     * @param i
     *            the index of the name
     * @return the value of the name

     */


    public static void main(String[] args) throws Exception {

        ArrayList<String> names = readNamesFromFile("/home/pablo-jdk/Documentos/Cursos/Java/sorting names/src/main/java/org/example/first_names.txt");
        Collections.sort(names);

        long totalScore = 0;

        for (int i =0; i< names.size(); i++){
            String name = names.get(i);
            int nameScore = calculateNameScore(name);
            long score = nameScore * (i + 1);
            totalScore += score;
        }

        System.out.println("The total of all the name scores in the file = " + totalScore);
    }

    private static int calculateNameScore(String name) {
        int score = 0;
        for (int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            score += (int) c - (int) 'A' + 1;
        }
        return score;
    }

    private static ArrayList<String> readNamesFromFile(String fileNane) {
        ArrayList<String> names = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(fileNane));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String name = scanner.next().replaceAll("\"", "");
                names.add(name);
            }
            scanner.close();
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }
        return names;
        }

    }
