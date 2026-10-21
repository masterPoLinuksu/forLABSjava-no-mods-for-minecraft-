package ru.zemerov.graph;

import java.util.ArrayList;

public class Route {
    public City start;
    public City end;
    public ArrayList<City> path = new ArrayList<City>();

    public Route(City start, City end) {
        if (start == null || end == null)
            throw new IllegalArgumentException("start/end не null");
        this.start = start;
        this.end = end;
        rebuildPath();
    }

    public void setStart(City start) {
        if (start == null) throw new IllegalArgumentException("start не null");
        this.start = start;
        rebuildPath();
    }

    public void setEnd(City end) {
        if (end == null) throw new IllegalArgumentException("end не null");
        this.end = end;
        rebuildPath();
    }

    public City[] getPath() {
        City[] arr = new City[path.size()];
        for (int i = 0; i < path.size(); i++) arr[i] = path.get(i);
        return arr;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) res += " -> ";
            res += path.get(i).name;
        }
        return res;
    }

    private void rebuildPath() {
        ArrayList<City> q = new ArrayList<City>();
        ArrayList<City> vis = new ArrayList<City>();
        ArrayList<City> parent = new ArrayList<City>();

        q.add(start);
        vis.add(start);
        parent.add(null);

        int idx = 0;
        boolean found = false;

        while (idx < q.size()) {
            City cur = q.get(idx);
            if (cur == end) {
                found = true;
                break;
            }
            for (int i = 0; i < cur.cities.size(); i++) {
                City next = cur.cities.get(i);
                if (!vis.contains(next)) {
                    q.add(next);
                    vis.add(next);
                    parent.add(cur);
                }
            }
            idx++;
        }

        path.clear();
        if (found) {
            City cur = end;
            ArrayList<City> tmp = new ArrayList<City>();
            while (cur != null) {
                tmp.add(cur);
                cur = parent.get(vis.indexOf(cur));
            }
            for (int i = tmp.size() - 1; i >= 0; i--) path.add(tmp.get(i));
        }
    }
}