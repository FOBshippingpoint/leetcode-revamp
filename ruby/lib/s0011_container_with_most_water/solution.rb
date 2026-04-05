# frozen_string_literal: true

# @param {Integer[]} height
# @return {Integer}
def max_area(height)
  head = 0
  tail = height.size - 1
  biggest = 0

  while head < tail
    headH = height[head]
    tailH = height[tail]
    area = (tail - head) * [headH, tailH].min
    biggest = [biggest, area].max

    if headH <= tailH
      head += 1
    else
      tail -= 1
    end
  end
  biggest
end
