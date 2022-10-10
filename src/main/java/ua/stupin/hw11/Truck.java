package ua.stupin.hw11;

public class Truck extends Car implements Recovery{

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

    @Override
    public double refuel(double quantityOfFuel) {
        if ((fuelLevel + quantityOfFuel) > sizeOfFuelTank) {
            System.out.println("Quantity to refuel is wrong, must be less then size of fuel tank");
        } else {
            fuelLevel = fuelLevel + quantityOfFuel;
        }
        return fuelLevel;
    }
}

