public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public void City (String name, String region, String district,
            int population, String foundation){
        this.setName(name);
        this.setRegion(region);
        this.setDistrict(district);
        this.setPopulation(population);
        this.setFoundation(foundation);
    }

    public void setName (String name){
        this.name = name;
    }
    public void setRegion (String region){
        this.region = region;
    }
    public void setDistrict (String district){
        this.district = district;
    }
    public void setPopulation (int population){
        this.population = population;
    }
    public void setFoundation (String foundation){
        this.foundation = foundation;
    }
    public String getName (){
        return this.name;
    }
    public String getRegion (){
        return this.region;
    }
    public String getDistrict (){
        return this.district;
    }
    public int getPopulation (){
        return this.population;
    }
    public String getFoundation (){
        return this.foundation;
    }
    public String toString(){
        return "City{" +
                "name='" + this.name +
                "', region='" + this.region +
                "', district='" + this.district +
                "', population=" + this.population +
                ", foundation='" + this.foundation +
                "'}";
    }
}
