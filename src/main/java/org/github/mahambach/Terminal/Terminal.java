package org.github.mahambach.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        boolean keepGoing = true;
        Scanner scanner = new Scanner(System.in);
        while(keepGoing){
            System.out.print("Enter command:");
            List<String> command;
            String input = scanner.nextLine();
            command = List.of(input.split(" "));
            if(command.contains("quit")) keepGoing = false;
            for(String string : command) System.out.println(string);

        }
    }
}
