# frozen_string_literal: true

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def search_v1(nums, target)
  # Find-any mode
  nums.bsearch_index { |x| target <=> x } || -1
end

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def search_v2(nums, target)
  # Find-minium mode
  idx = nums.bsearch_index { |x| x >= target }
  # If not found, it will return the FIRST index that satisfy
  # the condition x >= target, but not strictly matches x == target
  nums[idx] == target ? idx : -1
end

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def search_v3(nums, target)
  low = 0
  high = nums.size

  while low < high
    mid = low + (high - low) / 2
    val = nums[mid]
    if val < target
      low = mid + 1
    elsif val > target
      high = mid
    else
      return mid
    end
  end

  -1
end
