package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringProcessor {
    public String readInputText() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        return br.readLine();
    }

    public String processText(String inputText) {
        inputText.replaceAll("-", "_");
        String[] words = inputText.split("\\s+");
        return processWords(words);
    }

    public String processWords(String[] words) {
        String result = new String();
        boolean palindrom = true;
        for (String word : words) {
            for (int i = 0, j = word.length() - 1; i < j; ++i, --j) {
                if (word.charAt(i) != word.charAt(j)) {
                    palindrom = false;
                }
                else {
                    palindrom = true;
                }
            }
            if(palindrom) {
                result = result.concat("Palindrom: " + word + "\n");
            }
        }
        return result;
    }


    public void showResult(String resultText) {
        System.out.println(resultText);
    }


}