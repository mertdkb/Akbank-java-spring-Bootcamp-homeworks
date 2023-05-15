import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.House;
import entity.HouseType;
import entity.apartment.Apartment;
import entity.houseFactoryPattern.HouseFactory;
import entity.houseFactoryPattern.factory.HouseBluePrint;
import entity.service.HouseService;
import entity.summerHouse.SummerHouse;
import entity.villa.Villa;
import ui.HouseMenuUi;

public class App {
    public static void main(String[] args) throws Exception {

        // generates a ui for user
        HouseMenuUi ui = new HouseMenuUi();

        //keyboard scanner for user inputs
        Scanner kb = new Scanner(System.in);

        // gets all houses from houseFactory
        List<House> houses = initializeHouses();

        // house service instance gets all houses in list
        HouseService houseService = new HouseService(houses);

        // initializes app and starts for user to use
        ui.initializeApp(houseService, kb);

    }

    /*
     * this method generates all type of houses for generation this method uses factory pattern implementation, adds all generated houses to the list and returns as an list
     */
    private static List<House> initializeHouses() {
        List<House> houses = new ArrayList<>();
        HouseFactory houseFactory = new HouseFactory();

        for (int i = 0; i < 3; i++) {
            houses.add((Apartment) houseFactory.createApartment());
            houses.add((Villa) houseFactory.createVilla());
            houses.add((SummerHouse) houseFactory.createSummerHouse());
        }

        return houses;
    }

}
