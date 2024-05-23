package com.example.practice12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Service
public class FileWork {
    private static final Logger log = LoggerFactory.getLogger(FileWork.class);
    private File inputFile;
    private File outputFile;

    @Value("${inputFileName:src/main/resources/input.txt}")
    public static String inputFileName;

    @Value("${outputFileName:src/main/resources/output.txt}")
    public static String outputFileName;

    @PostConstruct
    public void init() {
        inputFile = new File(inputFileName);
        outputFile = new File(outputFileName);
        hashFile();
    }

    private void hashFile() {
        String res;
        try {
            Scanner scanner = new Scanner(inputFile);
            String data = scanner.next();
            res = String.valueOf(data.hashCode());
            scanner.close();

        } catch (FileNotFoundException e) {
            res = "null";
        }
        try {
            if (outputFile.createNewFile()) {
                System.out.println("Output file created");
            }
        } catch (IOException e) {
            System.out.println(outputFileName);
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void deleteFile() {
        if (!inputFile.delete())
            System.out.println("Delete file: input file doesn't exists");
    }
}