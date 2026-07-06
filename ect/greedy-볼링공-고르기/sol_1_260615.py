from itertools import combinations

n, m = input().split()
combos = combinations(map(int, input().split()), 2)

count = 0
for combo in combos:
    if combo[0] == combo[1]:
        continue
    count += 1

print(count)
