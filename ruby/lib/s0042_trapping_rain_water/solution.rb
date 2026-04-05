# frozen_string_literal: true

# @param {Integer[]} height
# @return {Integer}
def trap_v1(height)
  head = 0
  tail = height.size - 1
  max_head = height[head]
  max_tail = height[tail]
  area = 0

  while head < tail
    if max_head < max_tail
      head += 1
      max_head = [max_head, height[head]].max
      area += max_head - height[head]
    else
      tail -= 1
      max_tail = [max_tail, height[tail]].max
      area += max_tail - height[tail]
    end
  end
  area
end
