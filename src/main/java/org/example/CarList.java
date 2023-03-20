import java.util.ArrayList;
import java.util.Scanner;

public class CarList {

    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<Car>();

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новый автомобиль");
            System.out.println("2. Удалить автомобиль по регистрационному номеру");
            System.out.println("3. Удалить все автомобили из списка");
            System.out.print("Выберите пункт меню: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите марку машины: ");
                    String make = input.next();
                    System.out.print("Введите год выпуска: ");
                    int year = input.nextInt();
                    System.out.print("Введите регистрационный номер: ");
                    String regNo = input.next();
                    Car newCar = new Car(make, year, regNo);
                    if (carList.contains(newCar)) {
                        System.out.println("Автомобиль с таким регистрационным номером уже существует в списке!");
                    } else {
                        carList.add(newCar);
                        System.out.println("Автомобиль успешно добавлен в список!");
                    }
                    break;
                case 2:
                    System.out.print("Введите регистрационный номер удаляемого автомобиля: ");
                    regNo = input.next();
                    boolean removed = false;
                    for (Car car : carList) {
                        if (car.getRegNo().equals(regNo)) {
                            carList.remove(car);
                            removed = true;
                            System.out.println("Автомобиль успешно удален из списка!");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Автомобиль с таким регистрационным номером не найден в списке!");
                    }
                    break;
                case 3:
                    carList.clear();
                    System.out.println("Все автомобили успешно удалены из списка!");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Неправильный выбор!");
            }
            System.out.println("Текущий список автомобилей:");
            if (carList.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                for (Car car : carList) {
                    System.out.println(car.toString());
                }
            }
        } while (choice != 4);
        input.close();
    }

}

class Car {
    private String make;
    private int year;
    private String regNo;

    public Car(String make, int year, String regNo) {
        this.make = make;
        this.year = year;
        this.regNo = regNo;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getRegNo() {
        return regNo;
    }

    @Override
    public boolean equals(Object obj) {
        Car other = (Car) obj;
        return regNo.equals(other.regNo);
    }

    @Override
    public String toString() {
        return "Марка: " + make + ", год выпуска: " + year + ", регистрационный номер: " + regNo;
    }
}