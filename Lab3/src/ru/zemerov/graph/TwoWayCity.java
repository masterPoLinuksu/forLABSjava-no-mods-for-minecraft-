package ru.zemerov.graph;

public class TwoWayCity extends City {

    public TwoWayCity(String name) {
        super(name);
    }

    public TwoWayCity(
            String name,
            City[] otherCities,
            int[] otherCosts
    ) {
        this(name);

        if (otherCities == null || otherCosts == null) {
            throw new IllegalArgumentException("Массивы не должны быть null");
        }

        if (otherCities.length != otherCosts.length) {
            throw new IllegalArgumentException("Количество городов и стоимостей должно совпадать");
        }

        for (City city : otherCities) {
            if (city == null) {
                throw new IllegalArgumentException("Город не должен быть null");
            }
        }

        for (int i = 0; i < otherCities.length; i++) {
            addRoad(otherCities[i], otherCosts[i]);
        }
    }

    @Override
    public void addRoad(City city, int cost) {
        super.addRoad(city, cost);

        if (city instanceof TwoWayCity) {
            TwoWayCity other = (TwoWayCity) city;
            other.addReturnRoad(this, cost);
        } else {
            city.addRoad(this, cost);
        }
    }

    private void addReturnRoad(City city, int cost) {
        super.addRoad(city, cost);
    }
}