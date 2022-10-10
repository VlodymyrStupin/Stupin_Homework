package ua.stupin.hw11;

public class PassengerCar extends Car implements Recovery {

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

