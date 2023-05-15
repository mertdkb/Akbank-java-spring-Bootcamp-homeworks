package entity.apartment;

import entity.House;
import entity.HouseType;
import entity.houseFactoryPattern.factory.HouseBluePrint;

public class Apartment extends House implements HouseBluePrint{

    public Apartment(Long id, String name, int price, int squareMeter, int roomCount, int livingRoomCount) {
        this.id = id;
        this.name = name;
        this.houseType = HouseType.APARTMENT;
        this.price = price;
        this.squareMeter = squareMeter;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }

    /*
     * HouseBluePrintImpl generated code
     */
    @Override
    public void createHouse() {
        System.out.println("Aparment created");
    }


    @Override
    public HouseType getHouseType() {
        // TODO Auto-generated method stub
        return super.getHouseType();
    }

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public int getLivingRoomCount() {
        // TODO Auto-generated method stub
        return super.getLivingRoomCount();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public int getPrice() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }

    @Override
    public int getRoomCount() {
        // TODO Auto-generated method stub
        return super.getRoomCount();
    }

    @Override
    public int getSquareMeter() {
        // TODO Auto-generated method stub
        return super.getSquareMeter();
    }

    @Override
    public void setHouseType(HouseType houseType) {
        // TODO Auto-generated method stub
        super.setHouseType(houseType);
    }

    @Override
    public void setId(Long id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    @Override
    public void setLivingRoomCount(int livingRoomCount) {
        // TODO Auto-generated method stub
        super.setLivingRoomCount(livingRoomCount);
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        super.setName(name);
    }

    @Override
    public void setPrice(int price) {
        // TODO Auto-generated method stub
        super.setPrice(price);
    }

    @Override
    public void setRoomCount(int roomCount) {
        // TODO Auto-generated method stub
        super.setRoomCount(roomCount);
    }

    @Override
    public void setSquareMeter(int squareMeter) {
        // TODO Auto-generated method stub
        super.setSquareMeter(squareMeter);
    }


}
