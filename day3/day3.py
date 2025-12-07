total = 0

# day 3 part 1 
with open("day3.txt") as f:
    for bank in f:
        bank = bank.strip()

        best = 0

        for i in range(len(bank) - 1):
            tens = bank[i]

            ones = max(bank[i+1:])

            value = int(tens + ones)

            if value > best:
                best = value

        total += best

print(total)

# day 3 part 2 

def pick_largest_number(bank, pick_count):
    stack = []
    remaining = pick_count

    for i, digit in enumerate(bank):

        while stack and digit > stack[-1] and (len(stack) - 1 + len(bank) - i) >= remaining:
            stack.pop()

        if len(stack) < remaining:
            stack.append(digit)

    return "".join(stack[:pick_count])


total = 0

with open("day3.txt") as f:
    for bank in f:
        bank = bank.strip()
        best_number = int(pick_largest_number(bank, 12))
        total += best_number

print(total)
