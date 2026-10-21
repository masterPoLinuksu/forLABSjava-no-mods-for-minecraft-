package ru.zemerov.graph;

public class twocity extends City {
    public twocity(String name) {
        super(name);
    }

    public void addRoad(City city, int cost) {
        super.addRoad(city, cost);
        if (city instanceof twocity) {
            ((twocity) city).addRoadBack(this, cost);
        } else {
            city.addRoad(this, cost);
        }
    }

    private void addRoadBack(City city, int cost) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == city) {
                costs.set(i, cost);
                return;
            }
        }
        cities.add(city);
        costs.add(cost);
    }
}