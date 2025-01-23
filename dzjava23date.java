import java.io.*;
import java.util.*;

// №1 задание 
/*public class FileComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Введите путь к первому файлу: ");
        String filePath1 = scanner.nextLine();
        System.out.print("Введите путь ко второму файлу: ");
        String filePath2 = scanner.nextLine();

        try {
            List<String> file1Lines = readFile(filePath1);
            List<String> file2Lines = readFile(filePath2);
            
            System.out.println("Сравнение строк из двух файлов:");

            Set<String> uniqueInFile1 = new LinkedHashSet<>(file1Lines);
            Set<String> uniqueInFile2 = new LinkedHashSet<>(file2Lines);

            Set<String> commonLines = new HashSet<>(file1Lines);
            commonLines.retainAll(file2Lines);
            uniqueInFile1.removeAll(commonLines);
            uniqueInFile2.removeAll(commonLines);

            if (!uniqueInFile1.isEmpty()) {
                System.out.println("Строки, которые есть только в первом файле:");
                uniqueInFile1.forEach(System.out::println);
            } else {
                System.out.println("Нет уникальных строк в первом файле.");
            }

            if (!uniqueInFile2.isEmpty()) {
                System.out.println("Строки, которые есть только во втором файле:");
                uniqueInFile2.forEach(System.out::println);
            } else {
                System.out.println("Нет уникальных строк во втором файле.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }


    private static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}*/

// №2 задание
/*public class LongestLineFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        try {
            String longestLine = findLongestLine(filePath);

            if (longestLine != null) {
                System.out.println("Длина самой длинной строки: " + longestLine.length());
                System.out.println("Сама строка: " + longestLine);
            } else {
                System.out.println("Файл пуст или не содержит строк.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static String findLongestLine(String filePath) throws IOException {
        String longestLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (longestLine == null || currentLine.length() > longestLine.length()) {
                    longestLine = currentLine;
                }
            }
        }
        return longestLine;
    }
}*/

//№3 задание
/*public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        try {
            List<int[]> arrays = readArraysFromFile(filePath);
            System.out.println("Информация о массивах:");
            int totalSum = 0;

            for (int i = 0; i < arrays.size(); i++) {
                int[] array = arrays.get(i);
                int max = findMax(array);
                int min = findMin(array);
                int sum = findSum(array);
                totalSum += sum;

                System.out.println("Массив " + (i + 1) + ": " + Arrays.toString(array));
                System.out.println("  Максимум: " + max);
                System.out.println("  Минимум: " + min);
                System.out.println("  Сумма элементов: " + sum);
            }

            System.out.println("Общая сумма всех массивов: " + totalSum);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата чисел в файле: " + e.getMessage());
        }
    }

    private static List<int[]> readArraysFromFile(String filePath) throws IOException {
        List<int[]> arrays = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int[] array = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    array[i] = Integer.parseInt(parts[i]);
                }
                arrays.add(array);
            }
        }
        return arrays;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}*/

// №4 задание
/*public class ArrayToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        System.out.print("Введите элементы массива через пробел: ");
        String[] input = scanner.nextLine().trim().split("\\s+");
        int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        String originalArray = arrayToString(array);
        String evenArray = arrayToString(filterArray(array, true));
        String oddArray = arrayToString(filterArray(array, false));
        String reversedArray = arrayToString(reverseArray(array));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(originalArray);
            writer.newLine();
            writer.write(evenArray);
            writer.newLine();
            writer.write(oddArray);
            writer.newLine();
            writer.write(reversedArray);
            writer.newLine();
            System.out.println("Массивы успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static String arrayToString(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    private static int[] filterArray(int[] array, boolean even) {
        return Arrays.stream(array)
                     .filter(num -> even ? num % 2 == 0 : num % 2 != 0)
                     .toArray();
    }

    private static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}*/