# frozen_string_literal: true

# @param {Integer[]} nums
# @return {Integer[][]}
def three_sum_v1(nums)
  nums.sort!
  result = []
  tail = nums.size - 1
  head = 1

  (0...nums.size).each do |cur|
    next if cur.positive? && nums[cur] == nums[cur - 1]
    break if nums[cur].positive? # Given a sorted array, we are never gonna find 3 positive numbers that could sum to 0

    head = cur + 1
    tail = nums.size - 1

    while head < tail
      sum = nums[cur] + nums[head] + nums[tail]

      if sum.negative?
        head += 1
      elsif sum.positive?
        tail -= 1
      else
        result << [nums[cur], nums[head], nums[tail]]
        head += 1
        head += 1 while head < tail && nums[head] == nums[head - 1]
        tail -= 1
        tail -= 1 while head < tail && nums[tail] == nums[tail + 1]
      end
    end
  end
  result
end
