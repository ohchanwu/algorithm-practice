# 4 tries: 3 tests & 1 vague hint on performance optimization
# 1 <= n <= 100000
n = int(input())
ffs = sorted(list(map(int, input().split())))
# print(ffs)
groups = []

current = 0
while len(ffs) > current:
    length = ffs[current]
    groups.append(ffs[current : current + length])
    current += length
    while groups[-1][-1] > len(groups[-1]):
        if len(ffs) <= current:
            break
        groups[-1].append(ffs[current])
        current += 1

# print(groups)

result = len(groups)
if groups[-1][-1] != len(groups[-1]):
    result -= 1

print(result)
