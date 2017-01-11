package com.mycompany.util;

import java.util.UUID;

/**
 *
 * @author Jovan
 */
public class GeneralUtil {

    public static String getUniqueId() {
        return UUID.randomUUID().toString();
    }

}
