# copied from textbook with my own Counter twist
# try to redo it from memory
from collections import Counter

n, m = map(int, input().split())
data = list(map(int, input().split()))

counter = Counter(data)

result = 0
for i in range(1, m + 1):
    n -= counter[i]
    result += counter[i] * n

print(result)
