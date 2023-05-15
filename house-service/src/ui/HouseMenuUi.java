package ui;

import entity.service.HouseService;
import java.util.Scanner;

public class HouseMenuUi {

    /*
     * this method initializeApp and renders the menu user chooses an option process continues depending userMenuInput
     */
    public void initializeApp(HouseService houseService, Scanner kb) {
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

    /*
     * this method render filter choice menu and depending on room choice shows filtered houses
     */
    private void filterMenuView(HouseService houseService, Scanner kb) {
        System.out.print("Please enter living room count : ");
        int livingRoomUserInput = Integer.parseInt(kb.nextLine());

        System.out.print("Please enter room count : ");
        int roomUserInput = Integer.parseInt(kb.nextLine());

        houseService.printFilteredResults(houseService.filterAllTypeOfHouseByRoomCount(livingRoomUserInput, roomUserInput));
    }
}
