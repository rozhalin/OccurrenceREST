package interview.task.tone.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

class OccurrenceServiceTest {

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
}