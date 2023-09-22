package ArrayFunctions;

import java.util.Scanner;

public class ArrayMenu {
  Scanner prompt = new Scanner(System.in);
  String[] array = new String[10];
  String[] welcomeBanner = {
      "  __   __                                                                      _    _                     __   __  ",
      " / /  / /   __ _  _ __  _ __  __ _  _   _       ___   _ __    ___  _ __  __ _ | |_ (_)  ___   _ __   ___  \\ \\  \\ \\ ",
      "/ /  / /   / _` || '__|| '__|/ _` || | | |     / _ \\ | '_ \\  / _ \\| '__|/ _` || __|| | / _ \\ | '_ \\ / __|  \\ \\  \\ \\",
      "\\ \\  \\ \\  | (_| || |   | |  | (_| || |_| |    | (_) || |_) ||  __/| |  | (_| || |_ | || (_) || | | |\\__ \\  / /  / /",
      " \\_\\  \\_\\  \\__,_||_|   |_|   \\__,_| \\__, |     \\___/ | .__/  \\___||_|   \\__,_| \\__||_| \\___/ |_| |_||___/ /_/  /_/ ",
      "                                    |___/            |_|                                                           ",
      "                                                                                                                   "
  };
  String[] exitBanner = {
      "                                ____  ____    ____  ____       ____   ____  ",
      "                               | __ )/ ___|  / ___|/ ___|     |___ \\ |  _ \\ ",
      "                               |  _ \\\\___ \\ | |    \\___ \\       __) || | | |",
      "                               | |_) |___) || |___  ___) |     / __/ | |_| |",
      "                               |____/|____/  \\____||____/     |_____||____/ ",
      "                                               ____      _                ",
      "                                              |  _ \\    | |               ",
      "                                _____  _____  | |_) |_  | |  _____  _____ ",
      "                               |_____||_____| |  __/| |_| | |_____||_____|",
      "                                              |_|    \\___/                ",
      "                                                                           "
  };
  // FOR AESTHETICS-PURPOSES ONLY
  String RED_WARNING_ERROR = "\u001B[31m";
  String GREEN_SUCCESS = "\u001B[32m";
  String YELLOW_INFO = "\u001B[33m";
  String PROMPT_USER = "\u001B[35m";
  String CYAN = "\u001B[46m";
  String RESET = "\u001B[0m";

  public void init() {
    printBanner(welcomeBanner);

    System.out.println();

    // >> for program-printed information
    // > for prompt from user

    while (true) {
      System.out.println("Would you like to:");
      System.out.println("   >> Enter new array " + YELLOW_INFO + "(type \"new\")" + RESET);
      System.out.println("   >> Use randomly generated array of numbers " + YELLOW_INFO + "(type \"start\")" + RESET);
      System.out.println("   >> Exit program " + YELLOW_INFO + "(type \"exit\")" + RESET);
      System.out.println(RED_WARNING_ERROR + "   >>> Note: Commands are case-sensitive" + RESET);

      System.out.println();
      promptUser();
      String cmd = prompt.nextLine();

      // entry to program: following blocks of code compare if command is valid or
      // invalid
      if (cmd.equals("exit")) { // stop running program
        System.out.println();
        printBanner(exitBanner);

        return;
      }

      if (cmd.equals("new")) {
        System.out.println(">> Please enter " + array.length + " elements: (press >ENTER< after each element)");
        int i = 0;

        // assign elements from user to the array
        while (i < array.length) {
          System.out.print(PROMPT_USER + "> [" + i + "]: " + RESET);
          String element = prompt.nextLine();

          if (element.equals("")) { // if input is empty, it is considered null so we don't allow empty inputs!
            System.out.println(">> You can't enter an empty element, please try again.");
          } else {
            ArrayFunctions.update(i, element, array);
            i++;
          }
        }

      } else if (cmd.equals("start")) {
        array = ArrayFunctions.generateArray(array.length);
      } else {
        System.out.println(RED_WARNING_ERROR + ">> Invalid command\n" + RESET);
        continue; // continue from the top of loop
      }

      System.out.println(GREEN_SUCCESS + ">> Array initialization successful!" + RESET);
      System.out.println(ArrayFunctions.traverse(array) + "\n");

      // end of entry to program, next: ask user what operation they want to apply
      // to their array

      int result = operation();
      if (result == 1) {
        continue;
      } else if (result == -1) {
        System.out.println();
        printBanner(exitBanner);

        return;
      }
    }
  }

  public int operation() {
    String element;
    int index;
    String result = "";

    while (true) {
      System.out.println("Would you like to:");
      // System.out.println(" >> Print the array (type \"print\")"); // program prints
      // a lot so removed
      System.out.println("   >> Retrieve an element " + YELLOW_INFO + "(type \"get\")" + RESET);
      System.out.println("   >> Delete an element at index[n] " + YELLOW_INFO + "(type \"del\")" + RESET);
      System.out.println("   >> Update an element at index[n] " + YELLOW_INFO + "(type \"update\")" + RESET);
      System.out.println("   >> Insert an element at index[n] " + YELLOW_INFO + "(type \"insert\")" + RESET);
      System.out.println("   >> Go back to initializing array " + YELLOW_INFO + "(type \"back\")" + RESET);
      System.out.println("   >> Exit program " + YELLOW_INFO + "(type \"exit\")");
      System.out.println(RED_WARNING_ERROR + "   >>> Note: Commands are case-sensitive" + RESET);

      System.out.println();
      promptUser();
      String operation = prompt.nextLine();

      if (operation.equals("back")) { // GO BACK TO ARRAY INITIALIZATION
        return 1;
      } else if (operation.equals("exit")) { // STOP RUNNING PROGRAM
        return -1;
      }

      if (!(operation.equals("get") || operation.equals("del") || operation.equals("update")
          || operation.equals("insert") || operation.equals("back") || operation.equals("exit"))) {
        System.out.println(RED_WARNING_ERROR + ">> Invalid command\n" + RESET);
        continue;
      }

      try {
        System.out.println(ArrayFunctions.traverse(array) + "\n"); // print BEFORE OPERATION
        if (operation.equals("get")) { // RETRIEVE
          System.out.println(YELLOW_INFO + ">> Enter value of element to retrieve: " + RESET);
          promptUser();
          element = prompt.nextLine();
          result = ArrayFunctions.retrieve(element, array);
        } else if (operation.equals("del")) { // DELETE
          System.out.println(YELLOW_INFO + ">> Enter index of element to delete: " + RESET);
          promptUser();
          index = Integer.valueOf(prompt.nextLine());
          result = ArrayFunctions.delete(index, array);
        } else if (operation.equals("update")) { // UDPATE
          System.out.println(YELLOW_INFO + ">> Enter index of element to update: " + RESET);
          promptUser();
          index = Integer.valueOf(prompt.nextLine());
          System.out.println(YELLOW_INFO + ">> Enter new value of the given index: " + RESET);
          promptUser();
          element = prompt.nextLine();
          result = ArrayFunctions.update(index, element, array);
        } else if (operation.equals("insert")) { // INSERT
          System.out.println(YELLOW_INFO + ">> Enter index of element to insert: " + RESET);
          promptUser();
          index = Integer.valueOf(prompt.nextLine());
          System.out.println(YELLOW_INFO + ">> Enter value of element to be inserted: " + RESET);
          promptUser();
          element = prompt.nextLine();
          if (index < 0 || index >= array.length) {
            result = "Invalid index value, insertion failed.";
          } else {
            result = "Element " + element + " successfully inserted at index [" + index + "].";
          }
          array = ArrayFunctions.insert(index, element, array);
        } // INVALID INPUT
      } catch (NumberFormatException e) { // when user inputs a string when prompted for index value
        System.out.println(RED_WARNING_ERROR + ">> You entered an invalid value \n" + RESET);
        continue;
      }

      System.out.println(CYAN + ">> " + result + RESET);
      if (result.contains("Invalid")) {
        System.out.println();
        continue;
      }
      System.out.println("Array after the operation:");
      System.out.print(ArrayFunctions.traverse(array) + "\n"); // print AFTER OPERATION
    }
  }

  public void printBanner(String[] array) {
    for (String line : array) {
      System.out.println(line);
    }
  }

  public void promptUser() {
    System.out.print(PROMPT_USER + "> " + RESET);
  }
}