package lab2;

import java.util.ArrayList;

public class City {
    public String name;
    public ArrayList<City> cities = new ArrayList<City>();
    public ArrayList<Integer> costs = new ArrayList<Integer>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, City[] otherCities, int[] otherCosts) {
        this(name);

        if (otherCities == null || otherCosts == null) {
            throw new IllegalArgumentException("Массивы не должны быть null");
        }

        if (otherCities.length != otherCosts.length) {
            throw new IllegalArgumentException("Количество городов и стоимостей должно совпадать");
        }

        for (int i = 0; i < otherCities.length; i++) {
            if (otherCities[i] == null) {
                throw new IllegalArgumentException("Город не должен быть null");
            }

            addRoad(otherCities[i], otherCosts[i]);
        }
    }

    public void addRoad(City city, int cost) {
        cities.add(city);
        costs.add(cost);
    }

    @Override
    public String toString() {
        String result = name + " -> ";

        for (int i = 0; i < cities.size(); i++) {
            result = result + cities.get(i).name + ":" + costs.get(i) + " ";
        }

        return result.trim();
    }
}