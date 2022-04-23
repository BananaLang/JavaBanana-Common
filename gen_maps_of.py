for i in range(10):
    print('public static <K, V> Map<K, V> of(')
    for j in range(i):
        print(f'    K k{j + 1}, V v{j + 1},')
    print(f'    K k{i + 1}, V v{i + 1}')
    print(') {')
    print('    return of(new Object[] {')
    for j in range(i):
        print(f'        k{j + 1}, v{j + 1},')
    print(f'        k{i + 1}, v{i + 1}')
    print('    });')
    print('}')
