/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.util;


import java.util.ArrayList;
import java.util.List;

public abstract class PaginationUtils {
    private PaginationUtils() {
    }

    public static List<Integer> getPageList(int page, int radius, int size, int itemCount) {
        List<Integer> result = new ArrayList<Integer>();

        int lastPage = getLastPage(itemCount, size);

        int first = Math.max(page - radius, 1);
        int last = Math.min(page + radius, lastPage);

        for (int i = first; i <= last; ++i) {
            result.add(i);
        }

        return result;
    }

    public static int getLastPage(int itemCount, int size) {
        return (itemCount / size) + ((itemCount % size) > 0 ? 1 : 0);
    }
}
