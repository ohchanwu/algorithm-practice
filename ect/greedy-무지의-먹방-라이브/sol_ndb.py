# Need to use the 프로그래머스 UI for this.
# Keep in mind ndb doesn't use good variable names.
# Using good variable names demonstrates you understand the solution,
# so try your best to come up with good ones.
import heapq


def solution(food_times, k):
    if k >= sum(food_times):
        return -1

    heap = []
    for i, v in enumerate(food_times):
        heapq.heappush(heap, (v, i + 1))

    # next food to be zeroed
    next_threshold = 0
    # total amount of time elapsed
    elapsed = 0
    # count of remaining foods
    active_food_count = len(food_times)
    layers_consumed = 0

    while k >= elapsed + active_food_count * (heap[0][0] - layers_consumed):
        next_threshold = heapq.heappop(heap)[0]
        elapsed += active_food_count * (next_threshold - layers_consumed)
        active_food_count -= 1
        layers_consumed = next_threshold

    result = sorted(heap, key=lambda t: t[1])
    return result[(k - elapsed) % active_food_count][1]
