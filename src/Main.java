import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args){
        System.setProperty("file.encoding", "UTF-8");
        List<City> cities = CityUtils.parseCities();

        ArrayList<Integer> cityPopulationArray = CityUtils.makeArrayOfPopulation(cities);
        System.out.println(CityUtils.maxPopulation(cityPopulationArray));
    }
}