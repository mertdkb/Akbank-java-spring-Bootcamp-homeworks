package entity.houseFactoryPattern;

import java.util.ArrayList;
import java.util.List;

import entity.HouseType;
import entity.apartment.Apartment;
import entity.houseFactoryPattern.factory.HouseBluePrint;
import entity.summerHouse.SummerHouse;
import entity.villa.Villa;

public class HouseFactory {

    // this list is for keeping generated ids
    private List<Long> generatedIds = new ArrayList<Long>();

    /*
     * this method creates a new apartment with unique id and random details;
     */
    public HouseBluePrint createApartment() {
        return new Apartment(randomIdGenerator(), "APARTMENT", randomPriceGenerator(), randomSquareMeterGenerator(), randomRoomGenerator(), randomRoomGenerator());
    }

    /*
     * this method creates a new villa with unique id and random details;
     */
    public HouseBluePrint createVilla() {
        return new Villa(randomIdGenerator(), "VILLA", randomPriceGenerator(), randomSquareMeterGenerator(), randomRoomGenerator(), randomRoomGenerator());
    }

    /*
     * this method creates a new summer house with unique id and random details;
     */
    public HouseBluePrint createSummerHouse() {
        return new SummerHouse(randomIdGenerator(), "SUMMERHOUSE", randomPriceGenerator(), randomSquareMeterGenerator(), randomRoomGenerator(), randomRoomGenerator());
    }

    /*
     * this method creates a unique id
     */
    private Long randomIdGenerator() {
        long leftLimit = 1L;
        long rightLimit = 10L;

        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

        if (!generatedIds.contains(generatedLong)) {
            generatedIds.add(generatedLong);
            return generatedLong;
        }
        return randomIdGenerator();
    }

    /*
     * this method creates random price
     */
    private int randomPriceGenerator() {
        return (int)Math.floor(Math.random() * (200000000 - 1 + 1) + 1);
    }

    /*
     * this method creates random room count
     */
    private int randomRoomGenerator() {
        return (int)Math.floor(Math.random() * (10 - 1 + 1) + 1);
    }

    /*
     * this method creates random square meter
     */
    private int randomSquareMeterGenerator() {
        return (int)Math.floor(Math.random() * (1000 - 150 + 1) + 150);
    }
}
