n = input()
# "ff" stands for "fear factor"
ffs = list(map(int, input().split()))
ffs.sort()
highest_ff = max(ffs)
groups = [[] for _ in range(highest_ff)]

print(ffs)

for i, ff in enumerate(ffs):
    groups[ff - 1].append(ff)

print(groups)

for i, group in enumerate(groups):
    while len(group) > group[0]:
        if len(groups) == i + 1:
            groups.append([])
        groups[i + 1].insert(0, group[-1])
        group.pop()

print(groups)

count = 0
for group in groups:
    if len(group) >= group[-1]:
        count += 1

print(count)
