# 2 attempts: 1 index out of range error

s = input()

count0 = 0  # count of changes needed to make all digits '0'
count1 = 0  # count of changes needed to make all digits '1'

if s[0] == "0":
    count1 += 1
else:
    count0 += 1

# print(count0, count1)

for i in range(len(s) - 1):
    if s[i] != s[i + 1]:
        if s[i + 1] == "1":
            count0 += 1
        else:
            count1 += 1

# print(count0, count1)

print(min(count0, count1))
