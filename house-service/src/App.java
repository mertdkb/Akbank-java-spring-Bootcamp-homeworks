import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.House;
import entity.apartment.Apartment;
import entity.service.HouseService;
import entity.summerHouse.SummerHouse;
import entity.villa.Villa;

public class App {
    public static void main(String[] args) throws Exception {

        List<House> houses = initializeHouses();
        HouseService houseService = new HouseService(houses);
        Scanner kb = new Scanner(System.in);

        initializeApp(houseService, kb);

    }

    private static void initializeApp(HouseService houseService, Scanner kb) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("1) List all type of houses");
        System.out.println("2) List Apartments");
        System.out.println("3) List Villas");
        System.out.println("4) List Summer Houses");
        System.out.println("5) Filter All houses by living room count and room count");

        int userMenuInput = Integer.parseInt(kb.nextLine());

        while (true) {

            switch (userMenuInput) {
                case 1:
                    houseService.printAllHouses();
                    break;
                case 2:
                    houseService.printAllApartments();
                    break;
                case 3:
                    houseService.printAllVillas();
                    break;
                case 4:
                    houseService.printAllSummerHouses();
                    break;
                case 5:
                    filterMenuView(houseService, kb);
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            initializeApp(houseService, kb);
        }

    }

    private static void filterMenuView(HouseService houseService, Scanner kb) {
        System.out.print("Please enter living room count : ");
        int livingRoomUserInput = Integer.parseInt(kb.nextLine());

        System.out.print("Please enter room count : ");
        int roomUserInput = Integer.parseInt(kb.nextLine());

        houseService.printFilteredResults(houseService.filterAllTypeOfHouseByRoomCount(livingRoomUserInput, roomUserInput));
    }

    private static List<House> initializeHouses() {
        List<House> houses = new ArrayList<>();

        houses.addAll(apartmentGenerator());
        houses.addAll(villaGenertaor());
        houses.addAll(summerHouseGenerator());
        return houses;
    }

    private static List<Villa> villaGenertaor() {
        List<Villa> villas = new ArrayList<Villa>();

        Villa villa1 = new Villa((long) 100000000, "Villa1", 1000000, 300, 5, 2);
        Villa villa2 = new Villa((long) 100000001, "Villa2", 3000000, 700, 7, 4);
        Villa villa3 = new Villa((long) 100000002, "Villa3", 5000000, 1000, 10, 6);

        villas.add(villa1);
        villas.add(villa2);
        villas.add(villa3);

        return villas;
    }

    private static List<SummerHouse> summerHouseGenerator() {
        List<SummerHouse> summerHouses = new ArrayList<SummerHouse>();

        SummerHouse summerHouse1 = new SummerHouse((long) 200000000, "SummerHouse1", 10000, 250, 3, 1);
        SummerHouse summerHouse2 = new SummerHouse((long) 200000001, "SummerHouse2", 30000, 450, 6, 3);
        SummerHouse summerHouse3 = new SummerHouse((long) 200000002, "SummerHouse3", 50000, 650, 9, 5);

        summerHouses.add(summerHouse1);
        summerHouses.add(summerHouse2);
        summerHouses.add(summerHouse3);

        return summerHouses;
    }

    private static List<Apartment> apartmentGenerator() {
        List<Apartment> apartments = new ArrayList<Apartment>();

        Apartment apartment1 = new Apartment((long) 300000000, "Apartment1", 1000, 150, 3, 1);
        Apartment apartment2 = new Apartment((long) 300000001, "Apartment2", 3000, 350, 5, 2);
        Apartment apartment3 = new Apartment((long) 300000002, "Apartment3", 5000, 500, 7, 3);

        apartments.add(apartment1);
        apartments.add(apartment2);
        apartments.add(apartment3);
        return apartments;
    }
}
