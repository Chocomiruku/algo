package sorts.insert;

import static sorts.Utils.printArray;

public class InsertSort {
    // Сложность O(n^2)

    public static void insertSort(int[] array) {
        // Количество элементов в массиве
        int arrayLength = array.length;

        // Внешний цикл идет от второго элемента (индекс 1) до конца массива
        for (int i = 1; i < arrayLength; i++) {
            // Запоминаем текущий элемент
            int key = array[i];

            // Индекс предыдущего элемента
            int j = i - 1;

            // Внутренний цикл идет от текущего элемента в обратном порядке
            // до тех пор, пока не найдет элемент меньше ключа или не достигнет начала массива
            while (j >= 0 && array[j] > key) {
                // Сдвигаем элементы больше ключа вправо на одну позицию
                array[j + 1] = array[j];
                j--;
            }

            // Вставляем ключевой элемент на правильное место
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Данный массив");
        printArray(array);

        insertSort(array);

        System.out.println("\nОтсортированный массив");
        printArray(array);
    }
}
