package interview.task.tone.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

class TaskServiceTest {

    private final String longString;
    private final String shortString = "ccccbaaddd";
    private final Map<Character, Long> map = new LinkedHashMap<>() {
        {
            put('c', 4L);
            put('d', 3L);
            put('a', 2L);
            put('b', 1L);
        }
    };

    {
        try {
            longString = readText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readText() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    @Test
    @Order(1)
    void getOccurrenceMapPerformanceTest() {
        long startTime = System.nanoTime();
        Object occurrenceMap = new TaskService().getOccurrenceMap(longString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceMapPerformanceTest() longString: " + (stopTime - startTime));
    }

    @Test
    @Order(2)
    void getOccurrenceArrayPerformanceTest() {
        long startTime = System.nanoTime();
        Object occurrenceArray = new TaskService().getOccurrenceArray(longString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceArrayPerformanceTest() longString: " + (stopTime - startTime));
    }

    @Test
    @Order(3)
    void getOccurrenceMapTest() {
        long startTime = System.nanoTime();
        Object occurrenceMap = new TaskService().getOccurrenceMap(shortString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceMapTest() shortString: " + (stopTime - startTime));
    }

    @Test
    @Order(4)
    void getOccurrenceArrayTest() {
        long startTime = System.nanoTime();
        Object occurrenceArray = new TaskService().getOccurrenceArray(shortString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceArrayTest() shortString: " + (stopTime - startTime));
    }

    @Test
    @Order(5)
    void getOccurrenceCustomPerformanceTest() {
        long startTime = System.nanoTime();
        Object occurrenceArray = new TaskService().getOccurrenceCustom(longString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceCustomPerformanceTest() longString: " + (stopTime - startTime));
    }

    @Test
    @Order(6)
    void getOccurrenceCustomTest() {
        long startTime = System.nanoTime();
        Object occurrenceArray = new TaskService().getOccurrenceCustom(shortString);
        long stopTime = System.nanoTime();
        System.out.println("getOccurrenceCustomTest() shortString: " + (stopTime - startTime));
    }
}