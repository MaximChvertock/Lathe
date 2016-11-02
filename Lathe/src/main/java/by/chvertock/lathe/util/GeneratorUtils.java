/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.util;

import java.util.UUID;

public abstract class GeneratorUtils {
    private GeneratorUtils() {
    }

    public static String getUniqueId() {

        long result;

        do {
            result = UUID.randomUUID().getMostSignificantBits();
        } while (result <= 0);

        return "" + result;
    }
}
