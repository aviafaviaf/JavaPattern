package com.example.practice12;

// java -jar build/libs/practice12-0.0.1-SNAPSHOT.jar "src/main/resources/input.txt" "src/main/resources/output.txt"
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice12Application {
    public static void main(String[] args) {
        if (args.length == 2) {
            FileWork.inputFileName = args[0];
            FileWork.outputFileName = args[1];
        }

        SpringApplication.run(Practice12Application.class, args);
    }
}
