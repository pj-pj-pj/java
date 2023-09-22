package ArrayFunctions;

public class ArrayFunctions {
  public static void main(String[] args) {
  }

  static String retrieve(String element, String[] array) {
    // traverse the array until it founds a match to the given element
    for (int j = 0; j < array.length; j++) {
      if (element.equals(array[j])) {
        return "Element " + element + " successfully found at index [" + j + "].";
      }
    }

    // if the traversal didn't find any element until it reached the end
    return "Element " + element + " not found, retrieval failed.";
  }

  static String delete(int index, String[] array) {
    if (index < 0 || index >= array.length) {
      return "Invalid index value, deletion failed.";
    }

    // shift elements from right of index to be deleted
    for (int i = index; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }

    // replace the last element with null
    // because last and second to the last now has the same value
    update(array.length - 1, null, array);

    return "Element at index [" + index + "] successfully deleted.";
  }

  static String update(int index, String replacement, String[] array) {
    if (index < 0 || index >= array.length) {
      return "Invalid index value, updating failed.";
    }

    array[index] = replacement;

    return "Element at index [" + index + "] successsfully updated.";
  }

  static String[] insert(int index, String newElement, String[] array) {
    if (index < 0 || index >= array.length) {
      return array;
    }

    // if array has no available slot
    if (array[array.length - 1] != null) {
      String[] newArr = new String[array.length + 1];

      // copy original array to array with longer length
      for (int i = 0; i < index; i++) {
        newArr[i] = array[i];
      }

      // shift elements towards
      // the right of where the new element will be inserted
      for (int i = index + 1; i < newArr.length; i++) {
        newArr[i] = array[i - 1];
      }

      // assign new element to the given index
      newArr[index] = newElement;

      return newArr;
    } else {
      for (int i = array.length - 1; i > index; i--) {
        array[i] = array[i - 1];
      }

      // assign the new element to the given index
      array[index] = newElement;

      return array;
    }
  }
}