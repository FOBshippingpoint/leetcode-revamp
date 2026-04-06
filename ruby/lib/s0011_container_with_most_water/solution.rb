# frozen_string_literal: true

# @param {Integer[]} height
# @return {Integer}
def max_area(height)
  head = 0
  tail = height.size - 1
  biggest = 0

  while head < tail
    head_h = height[head]
    tail_h = height[tail]
    area = (tail - head) * [head_h, tail_h].min
    biggest = [biggest, area].max

    if head_h <= tail_h
      head += 1
    else
      tail -= 1
    end
  end
  biggest
end
