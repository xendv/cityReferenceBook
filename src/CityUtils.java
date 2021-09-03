import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityUtils {
    /**
     * Загрузка данных о городах в список
     * @return список объектов-городов
     */
    public static List<City> parseCities() {
        String filePath = "./city_ru.csv";
        List<City> cityList= new ArrayList<>();
        try{
            //line by line
            Scanner scanner = new  Scanner(new File(filePath)).useDelimiter("\n");
            while (scanner.hasNextLine()){
                //fields inside lines
                cityList.add(parseCity(scanner.nextLine()));
                //System.gc();
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("No input file found");
        }
        return cityList;
    }

    /**
     * Функция создания объекта-города из прочитанной строки
     * @param line - строка, содержащая параметры города, разделенные
     *             знаком ;
     * @return @link newCity - новый считанный объект-город
     */
    private static City parseCity (String line) {
        Scanner lineScanner = new Scanner(line).useDelimiter(";");
        //to skip line id use variable index
        int index = 0;
        City newCity = new City();
        while(lineScanner.hasNext()){
            String data = lineScanner.next();
            switch (index){
                case 1: newCity.setName(data);
                    break;
                case 2: newCity.setRegion(data);
                    break;
                case 3: newCity.setDistrict(data);
                    break;
                case 4: newCity.setPopulation(Integer.parseInt(data));
                    break;
                case 5: newCity.setFoundation(data);
                    break;
            }
            index++;
        }
        lineScanner.close();
        return newCity;
    }

    /**
     * Функция вывода объектов - городов
     * @param cities - список городов
     */
    public static void printCities(List<City> cities){
        //output
        for (City city : cities){
            System.out.println(city.toString());
        }
    }

    /**
     * Функция сортировки городов по имени в убывающем порядке
     * при помощи компаратора
     * @param cities
     */
    public static void sortCitiesByNameWithComparator(List<City> cities){
        cities.sort(new CityComparator.cityNameDescendingAlphabetComparator());
    }

    /**
     * Функция сортировки городов по ФО и имени в убывающем порядке
     * при помощи компаратора
     * @param cities
     */
    public static void sortCitiesByDistrictAndNameWithComparator(List<City> cities){
        cities.sort(new CityComparator.cityDistrictDescendingAlphabetComparator()
                .thenComparing(new CityComparator.cityNameDescendingAlphabetComparator()));
    }

    public static ArrayList<Integer> makeArrayOfPopulation(List<City> cities){
        ArrayList<Integer> cityPopulationArray = new ArrayList<>();
        for (City city: cities){
            cityPopulationArray.add(city.getPopulation());
        }
        return cityPopulationArray;
    }

    public static String getFormattedPopulation(Integer population){
        Integer tempInt = population;
        String formattedPopulation = "";
        while (population % 1000 != 0){
            formattedPopulation = population % 1000 + " " + formattedPopulation;
            population /= 1000;
        }
        return formattedPopulation;
    }

    public static String maxPopulation(ArrayList<Integer> cityPopulationArray) {
        int idMaxPopulation = -1; int maxPopulation = 0;
        for (Integer population: cityPopulationArray){
            if (population > maxPopulation){
                idMaxPopulation = cityPopulationArray.indexOf(population);
                maxPopulation = population;
            }
        }
        return "[" + idMaxPopulation + "] = " + getFormattedPopulation(maxPopulation);
    }
}
