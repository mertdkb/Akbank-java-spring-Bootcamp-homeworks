package entity.service;

import java.util.ArrayList;
import java.util.List;

import entity.House;
import entity.HouseType;
import entity.apartment.Apartment;
import entity.summerHouse.SummerHouse;
import entity.villa.Villa;

public class HouseService {
    private List<House> houses = new ArrayList<House>();

    private List<Apartment> apartments = new ArrayList<Apartment>();

    private List<Villa> villas = new ArrayList<Villa>();

    private List<SummerHouse> summerHouses = new ArrayList<SummerHouse>();

    //Constructor
    public HouseService(List<House> houses) {
        this.houses = houses;
        fillListsByHouseType(houses);
    }

    /*
     * This is an generic method it gets list of house and fills the list related to type of apartment
     */
    private <T extends House>void fillListsByHouseType(List<T> houses){
        for (T house : houses) {
            if (house.getHouseType() == HouseType.APARTMENT) {
                apartments.add((Apartment) house);
            }
            else if (house.getHouseType() == HouseType.VILLA) {
                villas.add((Villa) house);
            } else {
                summerHouses.add((SummerHouse) house);
            }
        } 
    }

    /*
     * This is an generic method it gets list of house and prints out the details of each element in the list
     */
    private <T extends House>void printAllTypeOfHouses(List<T> houses) {
        for (T house : houses) {
            System.out.println("\nType : " + house.getHouseType() + "\tName : " + house.getName() + "\tPrice : "
                    + house.getPrice() + "\nDetails : \tRoom Count : " + house.getRoomCount() + "\tLiving room count : "
                    + house.getLivingRoomCount() + "\tSquare meter : " + house.getSquareMeter() + "\n\nID : " + house.getId());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    /*
     * Prints out all houses with details and also prints sum prices of all elements in list and average square meter
     */
    public void printAllHouses(){
        System.out.println("#########----->ALL TYPE OF HOUSES<-----#########");

        printAllTypeOfHouses(this.houses);

        System.out.println("Sum prices of all Type of Houses : " + getAllTypeOfHousePrices());
        System.out.println("Average square meter of all Type of Houses : " + getAllTypeOfHouseAverageSquareMeter());
    }
    
    /*
     * Prints out all apartments with details and also prints sum prices of all elements in list and average square meter
     */
    public void printAllApartments() {
        System.out.println("#########----->APARTMENTS<-----#########");

        printAllTypeOfHouses(this.apartments);

        System.out.println("Sum Of all Apartments : " + getAllApartmentsPrices());
        System.out.println("Average square meter of apartment type of Houses : " + getAllApartmentsAverageSquareMeter());
    }

    /*
     * Prints out all villas with details and also prints sum prices of all elements in list and average square meter
     */
    public void printAllVillas() {
        System.out.println("#########----->VILLAS<-----#########");

        printAllTypeOfHouses(this.villas);

        System.out.println("Sum Of all Villas : " + getAllVillasPrices());
        System.out.println("Average square meter of villa type of Houses : " + getAllVillasAverageSquareMeter());
    }
 
    /*
     * Prints out all summer houses with details and also prints sum prices of all elements in list and average square meter
     */
    public void printAllSummerHouses() {
        System.out.println("#########----->SUMMER HOUSES<-----#########");
        printAllTypeOfHouses(this.summerHouses);

        System.out.println("Sum Of all Apartments : " + getAllSummerHousesPrices());
        System.out.println("Average square meter of summer house type of Houses : " + getAllSummerHousesAverageSquareMeter());
    }
    
    /*
     * This is an generic method it gets list of house as argument and prints out the total house prices
     */
    private <T extends House>int housePriceCalculator(List<T> houses) {
        int totalHousePrices = 0;

        for (House house : houses) {
            totalHousePrices += house.getPrice();
        }

        return totalHousePrices;
    }
    
    /*
     * return all type of house prices as an int
     */
    public int getAllTypeOfHousePrices() {
        return housePriceCalculator(this.houses);
    }

    /*
     * return all apartments prices as an int
     */
    public int getAllApartmentsPrices() {
        return housePriceCalculator(this.apartments);
    }

    /*
     * return all villas prices as an int
     */
    public int getAllVillasPrices() {
        return housePriceCalculator(this.villas);
    }

    /*
     * return all summer houses prices as an int
     */
    public int getAllSummerHousesPrices() {
        return housePriceCalculator(this.summerHouses);

    }

    /*
     * This is an generic method it gets list of house as argument and prints out the total house prices
     */
    private <T extends House> int averageSquareMeterCalc(List<T> houses) {
        int averageSquareMeter = 0;
        
        for (House house : houses) {
            averageSquareMeter += house.getSquareMeter();
        }
        averageSquareMeter = averageSquareMeter / (houses.size());

        return averageSquareMeter;
    }
    
    /*
     * returns average square meter of all houses as an int
     */
    public int getAllTypeOfHouseAverageSquareMeter() {
        return averageSquareMeterCalc(this.houses);
    }

    /*
     * returns average square meter of all apartments as an int
     */
    public int getAllApartmentsAverageSquareMeter() {
        return averageSquareMeterCalc(this.apartments);
    }

    /*
     * returns average square meter of all villas as an int
     */
    public int getAllVillasAverageSquareMeter() {
        return averageSquareMeterCalc(this.villas);
    }
 
    /*
     * returns average square meter of all summer house as an int
     */
    public int getAllSummerHousesAverageSquareMeter() {
        return averageSquareMeterCalc(this.summerHouses);
    }

    /*
     * This is an generic method it gets list of house as argument , living room count and room count after that filters all houses by room counts 
     */
    private <T extends House>List<T> filterHousesByRoomCountAndLivingRoomCount(List<T> houses, int livingRoom, int room){
        return houses.stream().filter(response -> response.getRoomCount() == room && response.getLivingRoomCount() == livingRoom).toList();
    }

    /*
     * filters all type of houses by room count as list
     */
    public List<House> filterAllTypeOfHouseByRoomCount(int livingRoom, int room){
        return filterHousesByRoomCountAndLivingRoomCount(this.houses, livingRoom, room);
    }

    /*
     * filters all apartments by room count as list
     */
    public List<Apartment> filterApartmentsTypeOfHouseByRoomCount(int livingRoom, int room){
        return filterHousesByRoomCountAndLivingRoomCount(this.apartments, livingRoom, room);
    }

    /*
     * filters all villas by room count as list
     */
    public List<Villa> filterVillasTypeOfHouseByRoomCount(int livingRoom, int room){
        return filterHousesByRoomCountAndLivingRoomCount(this.villas, livingRoom, room);
    }

    /*
     * filters all summer houses by room count as list
     */
    public List<SummerHouse> filterSummerHousesTypeOfHouseByRoomCount(int livingRoom, int room){
        return filterHousesByRoomCountAndLivingRoomCount(this.summerHouses, livingRoom, room);
    }

    /*
     * This is an generic method it gets list of houses as argument and print filtered data
     */
    public <T extends House>void printFilteredResults(List<T> houses){
        printAllTypeOfHouses(houses);
    }


    /*
     * Getters - Setters
     */
    public List<House> getHouses() {
        return houses;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Villa> getVillas() {
        return villas;
    }

    public List<SummerHouse> getSummerHouses() {
        return summerHouses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void setVillas(List<Villa> villas) {
        this.villas = villas;
    }

    public void setSummerHouses(List<SummerHouse> summerHouses) {
        this.summerHouses = summerHouses;
    }
}
