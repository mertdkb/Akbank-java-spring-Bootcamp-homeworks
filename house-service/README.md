# House service
This project is a plain Java project that utilizes the factory design pattern to create houses (`Apartment`, `Villa`, and `Summer house`) and provides functionality to print, filter based on room count and list of all types of houses.

Features of the Project:

 - Houses are created using the factory design pattern.
 - The project allows the creation of different types of houses, including Apartment, Villa, and Summer house.
 - All types of houses can be printed to the console for display.
 - The houses can be listed and filtered based on room and living room count.
 - The project is implemented using the Java programming language and designed as a simple console application.
 - By using this project, you can perform basic operations such as creating, listing, and filtering houses of different types.
 - The factory design pattern allows for extensibility to accommodate additional types of houses that may be added in the future.


---

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
```javascript

 If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

```
---
## Methods
---

 ## `Note : ` When service instance created it fills list by house type and below methods get houses from those lists.


```java
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
     * This method gets list of house and fills the list related to type of apartment
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
}
```
---
### Printing methods

```java
    /*
     * Prints out all houses with details
     */
     private <T extends House>void printAllTypeOfHouses(List<T> houses) {
        for (T house : houses) {
            System.out.println("\nType : " + house.getHouseType() 
                            + "\tName : " + house.getName() 
                            + "\tPrice : " + house.getPrice() 
                            + "\nDetails : \tRoom Count : " + house.getRoomCount() 
                            + "\tLiving room count : " + house.getLivingRoomCount() 
                            + "\tSquare meter : " + house.getSquareMeter() 
                            + "\n\nID : " + house.getId());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
```

`Note :` Below methods are implementing above method.

- `printAllHouses()`: Prints all houses;
  
- `printAllApartments()`: Prints all apartments.
  
- `printAllVillas()`: Prints all villas.
  
- `printAllSummerHouses()`: Prints all summer houses.

- `<T extends House>void printFilteredResults(List<T> houses)` : Gets list of houses as argument and print filtered data

---
### Get price methods

```java
     /*
     * This method gets list of houses as argument and prints out the total house prices
     */
    private <T extends House>int housePriceCalculator(List<T> houses) {
        int totalHousePrices = 0;

        for (House house : houses) {
            totalHousePrices += house.getPrice();
        }

        return totalHousePrices;
    }
```

`Note :` Below methods are implementing above method.

- `getAllTypeOfHousePrices()` : Returns`(int)` the total count of all type of house prices;
  
- `getAllApartmentsPrices()` : Returns`(int)` the total count of apartment prices;
  
- `getAllVillasPrices()` : Returns`(int)` the total count of villa prices;
  
- `getAllSummerHousesPrices()` : Returns`(int)` the total count of summer house prices;

---



```java
    /*
    * This method gets list of house as argument and prints out the total house prices
    */
    private <T extends House> int averageSquareMeterCalc(List<T> houses) {
        int averageSquareMeter = 0;
        
        for (House house : houses) {
            averageSquareMeter += house.getSquareMeter();
        }
        averageSquareMeter = averageSquareMeter / (houses.size());

        return averageSquareMeter;
    }
```

`Note :` Below methods are implementing above method.

- `getAllTypeOfHouseAverageSquareMeter()` : Returns`(int)` avarage square meter of all type of houses;
  
- `getAllApartmentsAverageSquareMeter()` : Returns`(int)` avarage square meter of apartments;
  
- `getAllVillasAverageSquareMeter()` : Returns`(int)` avarage square meter of villas;
  
- `getAllSummerHousesAverageSquareMeter()` : Returns`(int)` avarage square meter of summer houses;

---
### Filtering methods
```java
    /*
    * This method gets list of house, living room count and room count as an argument after that filters all houses by room counts 
    */
    private <T extends House>List<T> filterHousesByRoomCountAndLivingRoomCount(List<T> houses, int livingRoom, int room){
        return houses.stream().filter(response -> response.getRoomCount() == room && response.getLivingRoomCount() == livingRoom).toList();
    }

```

`Note :` Below methods are implementing above method.

- `filterAllTypeOfHouseByRoomCount(int livingRoom, int room)` : Returns`(List<House>)` the filtered result for all type of house;
  
- `filterApartmentsTypeOfHouseByRoomCount(int livingRoom, int room)` : Returns`(List<Apartment>)` the filtered result for all apartments;

- `filterVillasTypeOfHouseByRoomCount(int livingRoom, int room)` : Returns`(List<Villa>)` the filtered result for all villas;

- `filterSummerHousesTypeOfHouseByRoomCount(int livingRoom, int room)` : Returns`(List<SummerHouse>)` the filtered result for all summer houses;

---
If you have any questions or feedback regarding the project, please feel free to reach out to me. You can contact me through the following:

`Email:` dikbykmert@gmail.com

`Twitter:` @mertdkb