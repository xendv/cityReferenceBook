public class Main {
    public static void main (String[] args){
        System.setProperty("file.encoding", "UTF-8");
        CityUtils.printCities(CityUtils.parseCities());
    }
}