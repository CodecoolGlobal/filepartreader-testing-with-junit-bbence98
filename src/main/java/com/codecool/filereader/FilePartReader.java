package com.codecool.filereader;


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FilePartReader {
    String filePath;
    int fromLine;
    int toLine;

    public FilePartReader() {
        this.filePath = "/";
        this.fromLine = -2;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        if (fromLine < 1) throw new IllegalArgumentException("That's not good");
        this.fromLine = fromLine;
        if (toLine < fromLine) throw new IllegalArgumentException("That's not good");
        this.toLine = toLine;
    }

    public String read(String filePath) throws IOException {
        InputStream text = this.getClass().getResourceAsStream(filePath);
        Scanner scanner = new Scanner(text);
        StringBuilder result = new StringBuilder();

        while (scanner.hasNextLine()) {
            result.append(scanner.nextLine()).append("\n");
        }
        return result.toString();
    }

    public String readLines() throws IOException {
        String text = this.read(this.filePath);
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(text);
        int startRowCount = 1;
        System.out.println(toLine-fromLine);
        for (int i = 1; i < toLine; i++) {
            if (startRowCount == fromLine) {
                result.append(scanner.nextLine()).append("\n");
            } else {
                startRowCount++;
                scanner.nextLine();
            }
        }
        return result.toString();
    }


}
