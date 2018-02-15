package com.tw.intergalactic;

import com.tw.intergalactic.parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      printUsageAndExit();
    }

    List<String> lines = readFile(args[1]);
    Parser parser = new Parser();
    parser.parse(lines);
  }

  private static List<String> readFile(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void printUsageAndExit() {
    System.out.println("Usage: intergalactic.jar fileToParse");
  }
}
