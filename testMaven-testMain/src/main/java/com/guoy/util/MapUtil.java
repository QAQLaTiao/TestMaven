package com.guoy.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapUtil implements Comparator<String> {

    Map<String, Integer> base;
    public MapUtil(HashMap<String, Integer> map) {
        this.base = map;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
