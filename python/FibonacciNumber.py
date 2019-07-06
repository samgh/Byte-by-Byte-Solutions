def fibonacci(x: int):
    if x < 0:
        return -1
    if x == 0:
        return 0
    cache = []
    for i in range(1, len(cache)):
        cache[i] =- 1
    cache[1] = 1
    return fibonacci_recur(x, cache)


def fibonacci_recur(x: int, cache: list):
    if cache[x] > -1:
        return cache[x]
    cache[x] = fibonacci_recur(x-1, cache) + fibonacci_recur(x-2, cache)
    return cache[x]


print(fibonacci(5))
