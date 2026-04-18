# frozen_string_literal: true

# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays_v1(nums1, nums2)
  # Enforce nums1 is shorter than nums2
  return find_median_sorted_arrays_v1(nums2, nums1) if nums1.size > nums2.size

  x_size = nums1.size
  y_size = nums2.size
  low = 0
  high = x_size

  while low <= high
    cut_x = low + (high - low) / 2
    cut_y = (x_size + y_size + 1) / 2 - cut_x # Take 1 more elem to ensure BEFORE elem is median

    # ... cut_x-1 | cut_x ...
    before_x = cut_x.zero? ? -Float::INFINITY : nums1[cut_x - 1]
    after_x = nums1[cut_x] || Float::INFINITY
    # ... cut_y-1 | cut_y ...
    before_y = cut_y.zero? ? -Float::INFINITY : nums2[cut_y - 1]
    after_y = nums2[cut_y] || Float::INFINITY

    if before_x <= after_y && before_y <= after_x
      break
    elsif before_x > after_y
      high = cut_x - 1
    else
      low = cut_x + 1
    end
  end

  if (x_size + y_size).odd?
    [before_x, before_y].max
  else
    ([before_x, before_y].max + [after_x, after_y].min) / 2.0
  end
end
