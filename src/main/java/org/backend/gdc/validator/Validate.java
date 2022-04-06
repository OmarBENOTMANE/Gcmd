package org.backend.gdc.validator;

import org.backend.gdc.exceptions.technical.IllegalNullParamException;

public class Validate {

    static public void notNull(Object obj, String message) {
        if (null == obj)
            throw new IllegalNullParamException(message);
    }

    public static void isTrue(final boolean expression, final String message) {
        if (!expression) {
            throw new IllegalNullParamException(message);
        }
    }

}
