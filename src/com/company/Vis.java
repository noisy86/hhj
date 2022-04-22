package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Vis {
    public static void main(String[] args) {
        String[] words = {
                "hello", "world", "helloworld", "dodo", "pizza", "kokos", "banan", "led", "lorem", "ipsum"
        };
        String word = words[(int)(Math.random()*words.length)];
        ArrayList<Character> guessedChar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        StringBuilder wordTr;
        int count = 5;


        while (count > 0){
            System.out.println("\n");
            wordTr = new StringBuilder();
            System.out.println("lives count" + count );
            System.out.println();
            for (char slovko: word.toCharArray()) {
                if (slovko == ' ')                           wordTr.append(' ');
                else if (guessedChar.contains(slovko))    wordTr.append(slovko);
                else                                         wordTr.append("_");
            }



            System.out.println(wordTr);
            if (wordTr.indexOf("_") == -1) break;
            System.out.println();
            System.out.println("guessed chars");
            for (char piss: guessedChar) {
                System.out.print(piss + ", ");
            }
            System.out.println();
            System.out.println("guess char");
            char ins = (sc.nextLine() + " ").charAt(0);
            if (guessedChar.contains(ins) || word.indexOf(ins) == -1){
                count--;
                System.out.println("bad guess");
            }else{
                System.out.println("good guess");
            }
            if (!guessedChar.contains(ins)) guessedChar.add(ins);

        }

        if (count>0){
            System.out.println("WIN");
        }else {
            System.out.println(word);
            System.out.println(".R.I.P.");
        }
    }
}