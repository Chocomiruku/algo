package sorts.bubble;

import static sorts.Utils.printArray;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        // Количество элементов в массиве
        int arrayLength = array.length;

        // Внешний цикл проходит по всему массиву
        for (int i = 0; i < arrayLength - 1; i++) {
            // Флаг, показывающий был ли выполнен обмен элементов в текущем проходе
            boolean swapped = false;

            // Внутренний цикл идет от начала массива до последнего неотсортированного элемента
            for (int j = 0; j < arrayLength - i - 1; j++) {
                // Если текущий элемент больше следующего
                if (array[j] > array[j + 1]) {
                    // Меняем местами элементы
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // Отмечаем, что была совершена перестановка
                    swapped = true;
                }
            }

            // Если на этом проходе перестановок не было
            if (!swapped) {
                // Это означает, что массив уже отсортирован, можно прекращать работу
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Данный массив");
        printArray(array);

        bubbleSort(array);

        System.out.println("\nОтсортированный массив");
        printArray(array);
    }
}
