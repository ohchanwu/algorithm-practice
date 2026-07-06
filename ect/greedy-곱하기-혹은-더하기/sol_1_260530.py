# 2 tries without a hint

nums = list(map(int, list(input())))

total = nums[0]
for i in range(1, len(nums)):
    if total in {0, 1} or nums[i] in {0, 1}:
        total += nums[i]
    else:
        total *= nums[i]

print(total)
