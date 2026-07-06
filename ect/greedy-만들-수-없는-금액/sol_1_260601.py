_ = int(input())
nums = sorted(list(map(int, input().split())))
# print(nums)

current = 1

for n in nums:
    if n > current:
        break
    current += n

print(current)
