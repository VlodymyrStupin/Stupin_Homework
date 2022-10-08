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
public class Car {
    public String series;
    public int yearsOfProduction;
    public String colour;
    public int sizeOfFuelTank;
    public double fuelLevel;
    public double fuelEfficiency;

    public Car(String series, int yearsOfProduction, String colour, int sizeOfFuelTank,
               double fuelLevel, double fuelEfficiency) {
        this.series = series;
        this.yearsOfProduction = yearsOfProduction;
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

    static class PassengerCar extends Car {
        public int passenger;

        public PassengerCar(String series, int yearsOfProduction, String colour,
                            int sizeOfFuelTank, double fuelLevel, double fuelEfficiency, int passenger) {
            super(series, yearsOfProduction, colour, sizeOfFuelTank, fuelLevel, fuelEfficiency);
            this.passenger = passenger;
        }

        @Override
        public String moveCar(double distance) {
            double fuelLevelAfterMove = 0;
            for (int i = 0; i <= distance; i++) {
                if (fuelLevel == 0) {
                    return "Passenger car can't move, because fuel tank is empty";
                }
                if (fuelLevel != 0) {
                    fuelLevelAfterMove = fuelLevel - (fuelEfficiency / 100) * i;
                }
            }
            fuelLevel = fuelLevelAfterMove;
            return "Passenger car mowed " + distance + " and now fuel level is "
                    + fuelLevel;
        }

        @Override
        public String showStatistic() {
            return "In the passenger car " + colour + " " + series + " fuel level is - " + fuelLevel;
        }

        public int putPassengerInACar(int numberOfPassengers) {
            if (numberOfPassengers + passenger > 3) {
                System.out.println("There is no space for passengers");
            }
            if (passenger <= 0) {
                System.out.println("No more passengers in the passenger car");
            }
            return passenger;
        }
    }

    static class Truck extends Car {
        public int cargo;

        public Truck(String series, int yearsOfProduction, String colour, int sizeOfFuelTank,
                     double fuelLevel, double fuelEfficiency, int cargo) {
            super(series, yearsOfProduction, colour, sizeOfFuelTank, fuelLevel, fuelEfficiency);
            this.cargo = cargo;
        }

        @Override
        public String moveCar(double distance) {
            double fuelLevelAfterMove = 0;
            for (int i = 0; i <= distance; i++) {
                if (fuelLevel == 0) {
                    return "Truck can't move, because fuel tank is empty";
                }
                if (fuelLevel != 0) {
                    fuelLevelAfterMove = fuelLevel - ((fuelEfficiency * 2) / 100) * i;
                }
            }
            fuelLevel = fuelLevelAfterMove;
            return "Truck mowed " + distance + " and now fuel level is "
                    + fuelLevel;
        }

        @Override
        public String showStatistic() {
            return "In the truck " + colour + " " + series + " fuel level is - " + fuelLevel;
        }

        public String cargoLoading(int cargoToLoad) {
            if (cargoToLoad >= 0) {
                cargo = cargo + cargoToLoad;
            }
            if (cargo >= 21) {
                return "Overload, weight must be less then 21";
            }
            return "Cargo after load " + cargo;
        }

        public String cargoUnloading(int cargoToUnload) {
            if (cargoToUnload >= 0) {
                cargo = cargo - cargoToUnload;
            }
            if (cargo <= 0) {
                return "There is no cargo on a board";
            }
            return "Cargo after unload " + cargo;
        }
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
        Recovery recoveryForCar = (quantityOfFuel) -> {
            if ((car.fuelLevel + quantityOfFuel) > car.sizeOfFuelTank) {
                System.out.println("Quantity to refuel is wrong, must be less then size of fuel tank");
            } else {
                car.fuelLevel = car.fuelLevel + quantityOfFuel;
            }
            return car.fuelLevel;
        };
        Recovery recoveryForPassengerCar = (quantityOfFuel) -> {
            if ((passengerCar.fuelLevel + quantityOfFuel) > passengerCar.sizeOfFuelTank) {
                System.out.println("Quantity to refuel is wrong, must be less then size of fuel tank");
            } else {
                passengerCar.fuelLevel = passengerCar.fuelLevel + quantityOfFuel;
            }
            return passengerCar.fuelLevel;
        };
        Recovery recoveryForTruck = (quantityOfFuel) -> {
            if ((truck.fuelLevel + quantityOfFuel) > truck.sizeOfFuelTank) {
                System.out.println("Quantity to refuel is wrong, must be less then size of fuel tank");
            } else {
                truck.fuelLevel = truck.fuelLevel + quantityOfFuel;
            }
            return truck.fuelLevel;
        };
        System.out.println("Car fuel level after refuel "
                + recoveryForCar.refuel(car.sizeOfFuelTank - car.fuelLevel));
        System.out.println("Passenger car fuel level after refuel "
                + recoveryForPassengerCar.refuel(passengerCar.sizeOfFuelTank - passengerCar.fuelLevel));
        System.out.println("Truck fuel level after refuel "
                + recoveryForTruck.refuel(truck.sizeOfFuelTank - truck.fuelLevel));
    }
}
interface Recovery {
    double refuel(double quantityOfFuel);
}