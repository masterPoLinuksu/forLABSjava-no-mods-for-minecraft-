package ru.zemerov.graph;
import java.util.ArrayList;
import ru.zemerov.graph.TwoWayCity;

public class City {
    private String name;

    private final ArrayList<City> cities = new ArrayList<>();
    private final ArrayList<Integer> costs = new ArrayList<>();

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
            addRoad(otherCities[i], otherCosts[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void addRoad(City city, int cost) {
        if (city == null) {
            throw new IllegalArgumentException("Город не должен быть null");
        }

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == city) {
                costs.set(i, cost);
                return;
            }
        }

        cities.add(city);
        costs.add(cost);
    }

    public void removeRoad(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == city) {
                cities.remove(i);
                costs.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        String result = name + " -> ";

        if (cities.isEmpty()) {
            return result + "дорог нет";
        }

        for (int i = 0; i < cities.size(); i++) {
            result += cities.get(i).name + ":" + costs.get(i) + " ";
        }

        return result.trim();
    }
    //для 2.5 строки
    // Сколько исходящих дорог у города.
    public int getRoadCount() {
        return cities.size();
    }

    // В какой город ведёт дорога с указанным индексом.
    public City getRoadCity(int index) {
        return cities.get(index);
    }

    //для 6.5
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof City)) {
            return false;
        }

        City other = (City) obj;

        if (cities.size() != other.cities.size()) {
            return false;
        }

        for (int i = 0; i < cities.size(); i++) {
            boolean found = false;

            for (int j = 0; j < other.cities.size(); j++) {
                if (cities.get(i) == other.cities.get(j)
                        && costs.get(i).equals(other.costs.get(j))) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (int i = 0; i < cities.size(); i++) {
            int roadHash = 31 * System.identityHashCode(cities.get(i))
                    + costs.get(i).hashCode();

            result += roadHash;
        }

        return result;
    }
}
