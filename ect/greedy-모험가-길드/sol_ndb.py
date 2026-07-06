n = int(input())
adventurers = sorted(list(map(int, input().split())))

count = 0  # the number of adventurers in the current group
result = 0  # number of groups

for i in range(n):
    count += 1
    if adventurers[i] <= count:
        result += 1
        count = 0

print(result)
