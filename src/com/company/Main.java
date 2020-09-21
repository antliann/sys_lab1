package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            try {
                File myObj = new File("tolstoy.txt");
                Scanner myReader = new Scanner(myObj);
                List<String> result = new ArrayList<String>();
                int max_length = 30;
                String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZбвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";

                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    String[] words = line.split("[,  ?\"“”…‘.@;:/()$#^~`^!'\\\\%*\\-+=()_\n&<>{}\\]\\[]+");
                    for (String word : words) {
                        if (word.length() > max_length) {
                            word = word.substring(0, max_length);
                        }
                        for (int i = 1; i < word.length(); i++) {
                            if (word.charAt(i) == word.charAt(i - 1)) {
                                for (int n = 0; n < consonants.length(); n++) {
                                    if (word.charAt(i) == consonants.charAt(n)) {
                                        result.add(word);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                
                List<String> noDuplicates = new ArrayList<String>();
                for (String element : result) {
                    if (!noDuplicates.contains(element)) {
                        noDuplicates.add(element);
                    }
                }

                int counter = 0;
                for (String word : noDuplicates)
                {
                    counter++;
                    System.out.print(counter);
                    System.out.print(") ");
                    System.out.println(word);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
    }