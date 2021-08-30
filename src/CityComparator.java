import java.util.Comparator;

public class CityComparator {
    public static class cityNameDescendingAlphabetComparator implements Comparator<City> {
        @Override
        public int compare(City city1, City city2){
            return city1.getName().toLowerCase().compareTo(city2.getName().toLowerCase());
        }
    }
    public static class cityDistrictDescendingAlphabetComparator implements Comparator<City> {
        @Override
        public int compare(City city1, City city2){
            return city1.getDistrict().compareTo(city2.getDistrict());
        }
    }
    public static class cityDistrictAndNameDescendingAlphabetComparator implements Comparator<City> {
        @Override
        public int compare(City city1, City city2){
            return city1.getDistrict().compareTo(city2.getDistrict());
        }
    }
}
