package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringProcessor stringProcessor = new StringProcessor();
        String text = stringProcessor.readInputText();
        text = stringProcessor.processText(text);
        stringProcessor.showResult(text);
    }
}
