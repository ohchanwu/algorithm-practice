s = input()

# count of making everything into 0
count_0 = 0
# count of making everything into 1
count_1 = 0

if int(s[0]) == 1:
    count_0 += 1
else:
    count_1 += 1

for i in range(0, len(s) - 1):
    if s[i] != s[i + 1]:
        if int(s[i + 1]) == 0:
            count_1 += 1
        else:
            count_0 += 1

print(min(count_0, count_1))
