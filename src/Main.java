import java.util.List;

public class Main {
    public static void main (String[] args){
        System.setProperty("file.encoding", "UTF-8");
        List<City> cities = CityUtils.parseCities();

        CityUtils.printNumOfCitiesInRegions(cities);
    }
}