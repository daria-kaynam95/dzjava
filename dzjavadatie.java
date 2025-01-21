import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//№ 1 задание
/*public class StreamApiTask {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = IntStream.generate(() -> random.nextInt(2001) - 1000) // Диапазон [-1000, 1000]
                .limit(100) 
                .boxed() 
                .collect(Collectors.toList());


        long positiveCount = numbers.stream()
                .filter(num -> num > 0)
                .count();


        long negativeCount = numbers.stream()
                .filter(num -> num < 0)
                .count();


        long twoDigitCount = numbers.stream()
                .filter(num -> Math.abs(num) >= 10 && Math.abs(num) <= 99)
                .count();

        long palindromeCount = numbers.stream()
                .filter(StreamApiTask::isPalindrome)
                .count();

        System.out.println("Список чисел: " + numbers);
        System.out.println("Количество положительных чисел: " + positiveCount);
        System.out.println("Количество отрицательных чисел: " + negativeCount);
        System.out.println("Количество двузначных чисел: " + twoDigitCount);
        System.out.println("Количество зеркальных чисел: " + palindromeCount);
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(Math.abs(num)); 
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}*/

//№ 2 задание
/*public class StreamApiProducts {
    public static void main(String[] args) {
        List<String> products = List.of(
            "Молоко", "Хлеб", "Сыр", "Яйца", "Молочный коктейль", "Масло", "Кефир", "Молоко", "Сметана"
        );
        System.out.println("Все продукты: " + products);
        List<String> shortProducts = products.stream()
                .filter(product -> product.length() < 5)
                .collect(Collectors.toList());
        System.out.println("Продукты с количеством символов меньше пяти: " + shortProducts);


        List<String> foodSources = products.stream()
                .map(product -> product + " - источник питания")
                .collect(Collectors.toList());
        System.out.println("Продукты как источник питания: " + foodSources);


        char startLetter = 'М';
        List<String> productsStartingWithLetter = products.stream()
                .filter(product -> product.startsWith(String.valueOf(startLetter)))
                .collect(Collectors.toList());
        System.out.println("Продукты, начинающиеся на букву '" + startLetter + "': " + productsStartingWithLetter);


        List<String> milkCategory = products.stream()
                .filter(product -> product.contains("Молоко"))
                .collect(Collectors.toList());
        System.out.println("Продукты из категории 'Молоко': " + milkCategory);
    }
}*/

//№ 3 задание
/*class Device {
    private String name;
    private int year;
    private double price;
    private String color;
    private String type;

    public Device(String name, int year, double price, String color, String type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Device{name='%s', year=%d, price=%.2f, color='%s', type='%s'}", name, year, price, color, type);
    }
}

public class StreamApiDevices {
    public static void main(String[] args) {
        // Набор устройств
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Телевизор", 2020, 15000, "Черный", "Электроника"));
        devices.add(new Device("Смартфон", 2022, 50000, "Белый", "Электроника"));
        devices.add(new Device("Ноутбук", 2019, 70000, "Серый", "Компьютеры"));
        devices.add(new Device("Холодильник", 2018, 40000, "Белый", "Бытовая техника"));
        devices.add(new Device("Микроволновка", 2021, 10000, "Черный", "Бытовая техника"));

        System.out.println("Все устройства:");
        devices.forEach(System.out::println);


        String colorFilter = "Белый";
        List<Device> devicesByColor = devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(colorFilter))
                .collect(Collectors.toList());
        System.out.println("Устройства цвета '" + colorFilter + "': " + devicesByColor);


        int yearFilter = 2020;
        List<Device> devicesByYear = devices.stream()
                .filter(device -> device.getYear() == yearFilter)
                .collect(Collectors.toList());
        System.out.println("Устройства года выпуска '" + yearFilter + "': " + devicesByYear);


        double priceFilter = 20000;
        List<Device> devicesByPrice = devices.stream()
                .filter(device -> device.getPrice() > priceFilter)
                .collect(Collectors.toList());
        System.out.println("Устройства дороже " + priceFilter + ": " + devicesByPrice);


        String typeFilter = "Бытовая техника";
        List<Device> devicesByType = devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(typeFilter))
                .collect(Collectors.toList());
        System.out.println("Устройства типа '" + typeFilter + "': " + devicesByType);

        int yearStart = 2019;
        int yearEnd = 2021;
        List<Device> devicesByYearRange = devices.stream()
                .filter(device -> device.getYear() >= yearStart && device.getYear() <= yearEnd)
                .collect(Collectors.toList());
        System.out.println("Устройства с годом выпуска в диапазоне от " + yearStart + " до " + yearEnd + ": " + devicesByYearRange);
    }
}*/

//№ 4 задание
/*class Projector {
    private String name;
    private int year;
    private double price;
    private String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return String.format("Projector{name='%s', year=%d, price=%.2f, manufacturer='%s'}", name, year, price, manufacturer);
    }
}

public class StreamApiProjectors {
    public static void main(String[] args) {
        List<Projector> projectors = new ArrayList<>();
        projectors.add(new Projector("Epson EB-S41", 2020, 30000, "Epson"));
        projectors.add(new Projector("BenQ TK800", 2022, 75000, "BenQ"));
        projectors.add(new Projector("Sony VPL-VW270ES", 2019, 200000, "Sony"));
        projectors.add(new Projector("LG PF50KS", 2021, 55000, "LG"));
        projectors.add(new Projector("Acer X1123H", 2020, 25000, "Acer"));


        System.out.println("Все проекторы:");
        projectors.forEach(System.out::println);
 
        String manufacturerFilter = "Epson";
        List<Projector> projectorsByManufacturer = projectors.stream()
                .filter(projector -> projector.getManufacturer().equalsIgnoreCase(manufacturerFilter))
                .collect(Collectors.toList());
        System.out.println("Проекторы производителя '" + manufacturerFilter + "': " + projectorsByManufacturer);

        int currentYear = 2022;
        List<Projector> projectorsByYear = projectors.stream()
                .filter(projector -> projector.getYear() == currentYear)
                .collect(Collectors.toList());
        System.out.println("Проекторы года выпуска '" + currentYear + "': " + projectorsByYear);

        double priceFilter = 50000;
        List<Projector> projectorsByPrice = projectors.stream()
                .filter(projector -> projector.getPrice() > priceFilter)
                .collect(Collectors.toList());
        System.out.println("Проекторы дороже " + priceFilter + ": " + projectorsByPrice);

        List<Projector> projectorsSortedByPriceAsc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .collect(Collectors.toList());
        System.out.println("Проекторы, отсортированные по цене (по возрастанию): " + projectorsSortedByPriceAsc);

        List<Projector> projectorsSortedByPriceDesc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());
        System.out.println("Проекторы, отсортированные по цене (по убыванию): " + projectorsSortedByPriceDesc);

        List<Projector> projectorsSortedByYearAsc = projectors.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getYear(), p2.getYear()))
                .collect(Collectors.toList());
        System.out.println("Проекторы, отсортированные по году выпуска (по возрастанию): " + projectorsSortedByYearAsc);

        List<Projector> projectorsSortedByYearDesc = projectors.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear()))
                .collect(Collectors.toList());
        System.out.println("Проекторы, отсортированные по году выпуска (по убыванию): " + projectorsSortedByYearDesc);
    }
}*/

