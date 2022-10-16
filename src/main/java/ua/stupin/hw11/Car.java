package ua.stupin.hw11;

/*
a) Создать класс car (будет служить родительским)
        - с полями: серия, год, цвет, размер бака, текущее топливо, потребление топлива
        - с методами:
        I) движение (движется пока есть топливо),
        II) метод показать статистику
        - добавить конструктор на все поля
        b) Создать дочерний класс passenger car
        - добавить поле класс passenger
        - добавить метод посадить пассажира (в машине не может быть более 3 пассажиров)
        c) Создать дочерний класс truck
        - добавить поле cargo
        - добавить метод погрузки и выгрузки груза
        - переопределить метод движения (потребления топлива х2 от нормы)
        d) Создать интерфейс Recovery с методом refuel (восстанавливает топливо машины до полного значения)
        e) Имплементировать интерфейс в созданных ранее типах машин
 */
public class Car implements Recovery {
    public String series;
    public int yearOfProduction;
    public String colour;
    public int sizeOfFuelTank;
    public double fuelLevel;
    public double fuelEfficiency;

    public Car(String series, int yearOfProduction, String colour, int sizeOfFuelTank,
               double fuelLevel, double fuelEfficiency) {
        this.series = series;
        this.yearOfProduction = yearOfProduction;
        this.colour = colour;
        this.sizeOfFuelTank = sizeOfFuelTank;
        this.fuelLevel = fuelLevel;
        this.fuelEfficiency = fuelEfficiency;
    }

    public String moveCar(double distance) {
        double fuelLevelAfterMove = 0;
        for (int i = 0; i <= distance; i++) {
            if (fuelLevel == 0) {
                return "Car can't move, because fuel tank is empty";
            }
            if (fuelLevel != 0) {
                fuelLevelAfterMove = fuelLevel - (fuelEfficiency / 100) * i;
            }
        }
        fuelLevel = fuelLevelAfterMove;
        return "Car mowed " + distance + " and now fuel level is "
                + fuelLevel;
    }

    public String showStatistic() {
        return "In the car " + colour + " " + series + " fuel level is - " + fuelLevel;
    }

    public static void main(String[] args) {
        Car car = new Car("Audi a3", 2005, "white", 50, 50, 5);
        PassengerCar passengerCar = new PassengerCar("Audi a4", 2005, "white", 50, 50, 5, 0);
        Truck truck = new Truck("DAF", 207, "white", 200, 200, 10.0, 0);
        System.out.println(car.moveCar(100));
        System.out.println(car.moveCar(900));
        System.out.println(car.moveCar(20));
        System.out.println(car.showStatistic());
        System.out.println(passengerCar.moveCar(200));
        System.out.println(passengerCar.putPassengerInACar(5));
        System.out.println(passengerCar.showStatistic());
        System.out.println(truck.moveCar(100));
        System.out.println(truck.showStatistic());
        System.out.println(truck.cargoLoading(10));
        System.out.println(truck.cargoUnloading(5));
        System.out.println(truck.cargoLoading(10));
        System.out.println(truck.cargoLoading(1));
        System.out.println(truck.cargoUnloading(20));
        System.out.println("Car fuel level after refuel "
                + car.refuel(car.sizeOfFuelTank - car.fuelLevel));
        System.out.println("Passenger car fuel level after refuel " +
                passengerCar.refuel(passengerCar.sizeOfFuelTank - passengerCar.fuelLevel));
        System.out.println("Truck fuel level after refuel "
                + truck.refuel(truck.sizeOfFuelTank - truck.fuelLevel));
    }


    public double refuel(double quantityOfFuel) {
        if ((fuelLevel + quantityOfFuel) > sizeOfFuelTank) {
            System.out.println("Quantity to refuel is wrong, must be less then size of fuel tank");
        } else {
            fuelLevel = fuelLevel + quantityOfFuel;
        }
        return fuelLevel;
    }
}

interface Recovery {
    double refuel(double quantityOfFuel);
}
