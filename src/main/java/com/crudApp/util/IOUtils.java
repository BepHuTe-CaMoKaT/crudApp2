package com.crudApp.util;

import java.io.*;

public class IOUtils {

    public static String readFromFile(String path) {
        try {
            File file = new File(path);
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream in = new FileInputStream(file)) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                }
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in readFromFile" + e.getMessage());
        }
    }
    public static void writeToFile(String path, String text, boolean appendOrOverwriteTheFile) {
        try (FileWriter writer = new FileWriter(path, appendOrOverwriteTheFile)) {

            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
