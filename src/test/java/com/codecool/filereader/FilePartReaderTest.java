package com.codecool.filereader;

import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {

    @Test
    public void testIfSetupFromLineIsCorrect() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
           filePartReader.setup("/someText.txt", -2, 3);
        });
    }

    @Test
    public void testIfSetupToLineIsCorrect() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
           filePartReader.setup("/someText.txt", 5, 3);
        });
    }

    @Test
    public void testIfReadLinesRowsCounterMatchExpectedNumber() throws IOException {
        int counter;
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/someText.txt", 1, 9);
        String[] text = filePartReader.readLines().split("\n");
        counter = (int) Stream.of(text).count();
        if (filePartReader.fromLine > 1) {
            assertEquals(filePartReader.toLine - filePartReader.fromLine, counter);
        }
    }

}