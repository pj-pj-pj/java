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
      "                ____  ____    ____  ____       ____   ____  ",
      "               | __ )/ ___|  / ___|/ ___|     |___ \\ |  _ \\ ",
      "               |  _ \\\\___ \\ | |    \\___ \\       __) || | | |",
      "               | |_) |___) || |___  ___) |     / __/ | |_| |",
      "               |____/|____/  \\____||____/     |_____||____/ ",
      "                               ____      _                ",
      "                              |  _ \\    | |               ",
      "                _____  _____  | |_) |_  | |  _____  _____ ",
      "               |_____||_____| |  __/| |_| | |_____||_____|",
      "                              |_|    \\___/                ",
      "                                                           "
  };

  public void init() {
    printBanner(welcomeBanner);

    System.out.println();

    while (true) {
      System.out.println("Would you like to:");
      System.out.println("   >> Enter new array (type \"new\")");
      System.out.println("   >> Use randomly generated array of numbers (type \"start\")");
      System.out.println("   >> Exit program (type \"exit\")");

      System.out.print("\n> ");
      String cmd = prompt.nextLine();

      // entry to program: following blocks of code compare if command is valid or
      // invalid
      if (cmd.equalsIgnoreCase("exit")) { // stop running program
        System.out.println();
        printBanner(exitBanner);

        return;
      }

      if (cmd.equalsIgnoreCase("new")) {
        System.out.println(">> Please enter 10 elements: (press >ENTER< after each element)");
        int i = 0;

        // assign 10 numbers to the array
        while (i < array.length) {
          System.out.print("> [" + i + "]: ");
          String element = prompt.nextLine();

          if (element.equals("")) { // if input is empty, it is considered null so we don't allow empty inputs!
            System.out.println(">> You can't enter an empty element, please try again.");
          } else {
            ArrayFunctions.update(i, element, array);
            i++;
          }
        }

      } else if (cmd.equalsIgnoreCase("start")) {
        array = ArrayFunctions.generateArray(array.length);
      } else {
        System.out.println(">> Invalid command\n");
        continue;
      }

      System.out.println(ArrayFunctions.traverse(array) + "\n");

      // end of entry to program, next we ask user what operation they want to apply
      // to their array

    }
  }

  public void printBanner(String[] array) {
    for (String line : array) {
      System.out.println(line);
    }
  }
}