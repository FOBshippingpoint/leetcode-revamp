# frozen_string_literal: true

# Convert to set and compare size with original nums
#
# @param {Integer[]} nums
# @return {Boolean}
def contains_duplicate_v1(nums)
  nums.to_set.size != nums.size
end

# Use set
#
# @param {Integer[]} nums
# @return {Boolean}
def contains_duplicate_v2(nums)
  s = Set.new
  nums.each do |num|
    return true unless s.add?(num)
  end
  false
end

# Use the hash instead of Set
#
# @param {Integer[]} nums
# @return {Boolean}
def contains_duplicate_v3(nums)
  h = {}
  nums.each do |n|
    return true if h.key? n

    h[n] = true
  end
  false
end
