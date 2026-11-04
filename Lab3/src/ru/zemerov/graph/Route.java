package ru.zemerov.graph;

import java.util.ArrayList;

public class Route {
    private City start;
    private City end;

    public Route(City start, City end) {
        setStart(start);
        setEnd(end);
    }

    public City getStart() {
        return start;
    }

    public City getEnd() {
        return end;
    }

    public void setStart(City start) {
        if (start == null) {
            throw new IllegalArgumentException("Начальный город не должен быть null");
        }

        this.start = start;
    }

    public void setEnd(City end) {
        if (end == null) {
            throw new IllegalArgumentException("Конечный город не должен быть null");
        }

        this.end = end;
    }

    public City[] getPath() {
        ArrayList<City> found = new ArrayList<>();
        ArrayList<Integer> previous = new ArrayList<>();

        found.add(start);
        previous.add(-1);

        for (int i = 0; i < found.size(); i++) {
            City current = found.get(i);

            if (current == end) {
                return buildPath(found, previous, i);
            }

            for (int j = 0; j < current.getRoadCount(); j++) {
                City next = current.getRoadCity(j);

                if (!containsCity(found, next)) {
                    found.add(next);
                    previous.add(i);
                }
            }
        }

        return new City[0];
    }

    private boolean containsCity(ArrayList<City> cities, City city) {
        for (City current : cities) {
            if (current == city) {
                return true;
            }
        }

        return false;
    }

    private City[] buildPath(
            ArrayList<City> found,
            ArrayList<Integer> previous,
            int endIndex
    ) {
        int length = 0;
        for (int i = endIndex; i != -1; i = previous.get(i)) {
            length++;
        }

        City[] path = new City[length];
        int index = endIndex;

        for (int i = length - 1; i >= 0; i--) {
            path[i] = found.get(index);
            index = previous.get(index);
        }

        return path;
    }

    @Override
    public String toString() {
        City[] path = getPath();

        if (path.length == 0) {
            return "Маршрут отсутствует";
        }

        String result = path[0].getName();

        for (int i = 1; i < path.length; i++) {
            result += " -> " + path[i].getName();
        }

        return result;
    }
}