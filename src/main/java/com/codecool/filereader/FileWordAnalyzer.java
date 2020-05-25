package com.codecool.filereader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> orderedWords = new ArrayList<>();
        String text = filePartReader.readLines();
        String[] words = text.split("\\s+");
        for (String word : words) {
            String lowerCase = word.toLowerCase();
            orderedWords.add(lowerCase);
        }
        Collections.sort(orderedWords);
        return orderedWords;
    }

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        List<String> filteredWords = new ArrayList<>();
        String text = filePartReader.readLines();
        String[] words = text.split("\\s+");
        Stream.of(words).filter(t -> t.contains(substring)).forEach(filteredWords::add);
        return filteredWords;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> palindromeWords = new ArrayList<>();
        String text = filePartReader.readLines().trim();
        String[] words = text.split("\\s+");
        for (String word : words) {
            String lowerCaseWords = word.toLowerCase();
            StringBuilder reverse = new StringBuilder();
            for (int i = word.length()-1; i >= 0 ; i--) {
                reverse.append(lowerCaseWords.charAt(i));
            }
            if (lowerCaseWords.equals(reverse.toString())) palindromeWords.add(reverse.toString());
        }
        return palindromeWords;
    }
}
