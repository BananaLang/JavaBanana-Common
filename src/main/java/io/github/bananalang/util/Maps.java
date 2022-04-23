package io.github.bananalang.util;

import java.util.HashMap;
import java.util.Map;

public final class Maps {
    private Maps() {
    }

    public static <K, V> Map<K, V> of(
        K k1, V v1
    ) {
        return of(new Object[] {
            k1, v1
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5,
        K k6, V v6
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5,
            k6, v6
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5,
        K k6, V v6,
        K k7, V v7
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5,
            k6, v6,
            k7, v7
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5,
        K k6, V v6,
        K k7, V v7,
        K k8, V v8
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5,
            k6, v6,
            k7, v7,
            k8, v8
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5,
        K k6, V v6,
        K k7, V v7,
        K k8, V v8,
        K k9, V v9
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5,
            k6, v6,
            k7, v7,
            k8, v8,
            k9, v9
        });
    }
    public static <K, V> Map<K, V> of(
        K k1, V v1,
        K k2, V v2,
        K k3, V v3,
        K k4, V v4,
        K k5, V v5,
        K k6, V v6,
        K k7, V v7,
        K k8, V v8,
        K k9, V v9,
        K k10, V v10
    ) {
        return of(new Object[] {
            k1, v1,
            k2, v2,
            k3, v3,
            k4, v4,
            k5, v5,
            k6, v6,
            k7, v7,
            k8, v8,
            k9, v9,
            k10, v10
        });
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> of(Object... entries) {
        if ((entries.length & 1) != 0) {
            throw new IllegalArgumentException("entries must have an equal number of keys and values");
        }
        Map<K, V> result = new HashMap<>();
        for (int i = 0; i < entries.length; i += 2) {
            result.put((K)entries[i], (V)entries[i + 1]);
        }
        return result;
    }
}
