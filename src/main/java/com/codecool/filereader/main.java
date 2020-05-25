package com.codecool.filereader;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/someText.txt", 4, 8);
        System.out.println();
        System.out.println(filePartReader.readLines());

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
    }
}
