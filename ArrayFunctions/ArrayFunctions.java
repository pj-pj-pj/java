package ArrayFunctions;

public class ArrayFunctions {
  public static void main(String[] args) {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println();

    System.out.println(retrieve(5, numbers));
    System.out.println(delete(5, numbers));
    System.out.println(update(3, 100, numbers));

    System.out.println("\n");

    for (int i = 0; i < numbers.length - 1; i++) {
      System.out.print(numbers[i] + ",");
    }

    System.out.println("\n");
  }

  static String retrieve(int num, int[] array) {
    for (int j = 0; j < array.length - 1; j++) {
      if (num == array[j]) {
        return "Element " + num + " successfully found at index [" + j + "].";
      }
    }

    return "Element " + num + " not found.";
  }

  static String delete(int index, int[] array) {
    if (index < 0 || index >= array.length) {
      return "Invalid index value.";
    }

    for (int i = index; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }

    return "Element at index [" + index + "] sucessfully deleted.";
  }

  static String update(int index, int replacement, int[] array) {
    if (index < 0 || index >= array.length) {
      return "Invalid index value";
    }

    array[index] = replacement;

    return "Element at index [" + index + "] successsfully updated.";
  }
}