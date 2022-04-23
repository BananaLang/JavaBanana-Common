package io.github.bananalang.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public final class OneToManyHashMap<K, V> implements Map<K, Set<V>> {
    private final Map<K, Set<V>> delegate;
    private final Supplier<Set<V>> setSupplier;

    public OneToManyHashMap(int initialCapacity, Supplier<Set<V>> setSupplier) {
        delegate = new HashMap<>(initialCapacity);
        this.setSupplier = setSupplier;
    }

    public OneToManyHashMap(int initialCapacity) {
        delegate = new HashMap<>(initialCapacity);
        setSupplier = HashSet::new;
    }

    public OneToManyHashMap(Supplier<Set<V>> setSupplier) {
        delegate = new HashMap<>();
        this.setSupplier = setSupplier;
    }

    public OneToManyHashMap() {
        delegate = new HashMap<>();
        setSupplier = HashSet::new;
    }

    public OneToManyHashMap(OneToManyHashMap<K, V> m) {
        delegate = new HashMap<>(m.delegate);
        setSupplier = m.setSupplier;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<V> get(Object key) {
        return delegate.computeIfAbsent((K)key, k -> setSupplier.get());
    }

    @Override
    public Set<V> put(K key, Set<V> value) {
        Set<V> backendSet = get(key);
        backendSet.addAll(value);
        return backendSet;
    }

    public Set<V> put(K key, V value) {
        Set<V> backendSet = get(key);
        backendSet.add(value);
        return backendSet;
    }

    @Override
    public Set<V> remove(Object key) {
        return delegate.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends Set<V>> m) {
        for (Entry<? extends K, ? extends Set<V>> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public Set<K> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<Set<V>> values() {
        return delegate.values();
    }

    public Set<V> allValues() {
        Set<V> result = setSupplier.get();
        for (Set<V> set : values()) {
            result.addAll(set);
        }
        return result;
    }

    @Override
    public Set<Entry<K, Set<V>>> entrySet() {
        return delegate.entrySet();
    }
}
