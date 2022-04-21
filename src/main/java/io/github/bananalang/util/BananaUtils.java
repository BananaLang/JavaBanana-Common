package io.github.bananalang.util;

import java.util.Objects;

public final class BananaUtils {
    private BananaUtils() {
    }

    public static String moduleToClassName(String moduleName) {
        if (Objects.requireNonNull(moduleName, "moduleName").isEmpty()) {
            throw new IllegalArgumentException(moduleName);
        }
        int dotIndex = moduleName.lastIndexOf('.');
        if (dotIndex == -1) {
            return "Module" + Character.toUpperCase(moduleName.charAt(0)) + moduleName.substring(1);
        }
        return moduleName.substring(0, dotIndex)
            + ".Module"
            + Character.toUpperCase(moduleName.charAt(dotIndex + 1))
            + moduleName.substring(dotIndex + 2);
    }
}
