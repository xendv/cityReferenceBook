import java.util.List;

public class Main {
    public static void main (String[] args){
        System.setProperty("file.encoding", "UTF-8");
        List<City> cities = CityUtils.parseCities();

        System.out.println("\tСортировка списка городов по " +
                        "наименованию в алфавитном порядке по убыванию " +
                        "без учета регистра:");
        sortCitiesByNameWithComparator(cities);
        CityUtils.printCities(cities);

        System.out.println("\n\tСортировка списка городов по " +
                "федеральному округу " +
                "и наименованию города внутри каждого федерального округа " +
                "в алфавитном порядке по убыванию с учетом регистра:");
        sortCitiesByDistrictAndNameWithComparator(cities);
        CityUtils.printCities(cities);
    }

    public static void sortCitiesByNameWithComparator(List<City> cities){
        cities.sort(new CityComparator.cityNameDescendingAlphabetComparator());
    }
    public static void sortCitiesByDistrictAndNameWithComparator(List<City> cities){
        cities.sort(new CityComparator.cityDistrictDescendingAlphabetComparator()
                .thenComparing(new CityComparator.cityNameDescendingAlphabetComparator()));
    }
}