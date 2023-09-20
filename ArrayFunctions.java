public class ArrayFunctions {
  public static void main(String[] args) {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println((retrieve(5, numbers)));
  }

  static String retrieve(int num, int[] array) {
    for (int j = 0; j < array.length; j++) {
      if (num == array[j]) {
        return "Element " + num + " successfully found at index [" + j + "].";
      }
    }

    return "Element " + num + " not found.";
  }
}