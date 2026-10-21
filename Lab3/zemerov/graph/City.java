package ru.zemerov.graph;

import java.util.ArrayList;

public class City {
    public String name;
    public ArrayList<City> cities = new ArrayList<City>();
    public ArrayList<Integer> costs = new ArrayList<Integer>();

    public City(String name) {
        this.name = name;
    }

    public void addRoad(City city, int cost) {
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

    public String toString() {
        String res = name + " -> ";
        for (int i = 0; i < cities.size(); i++) {
            res += cities.get(i).name + ":" + costs.get(i) + " ";
        }
        return res;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof City)) return false;
        City other = (City) o;
        if (this.cities.size() != other.cities.size()) return false;
        for (int i = 0; i < this.cities.size(); i++) {
            boolean found = false;
            for (int j = 0; j < other.cities.size(); j++) {
                if (this.cities.get(i) == other.cities.get(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}