package com.fghcorp;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

//What to do with an exception
//1. return alternative answer
//2. print to the screen (meh), e.printStackTrace
//3. logger (log4j, jul, slf-4j, logback)
//4. let it blow all the way up the stack. (Nice, but aggravating)
public class Oops {

    public static void potentialToBoom() throws CustomException {
        throw new CustomException("I don't like you");
    }

    public static void middleMan() throws CustomException {
        potentialToBoom();
    }

    public static int calc() {
        int n = 3;
        try {
            return 10 / n;
        } catch (ArithmeticException e) {
            return -1;
        } finally {
            System.out.println("Always run");
        }
    }

    public static void main(String[] args) throws CustomException {
        try {
            Files.lines(Paths.get
                (new URI("file:///home/danno/Desktop/eks-stage-full.tf")));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

       middleMan();
    }
}
