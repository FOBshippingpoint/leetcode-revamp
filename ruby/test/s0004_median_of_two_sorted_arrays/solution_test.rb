# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0004_median_of_two_sorted_arrays/solution'

describe 'find median sorted arrays' do
  test_cases = [
    { nums1: [1, 3], nums2: [2], expected: 2 },
    { nums1: [1, 2], nums2: [3, 4], expected: 2.5 },
    { nums1: [7, 8, 9], nums2: [1, 2], expected: 7 },
    { nums1: [1, 2, 3, 5], nums2: [2, 4, 6], expected: 3 },
    { nums1: [], nums2: [1, 2, 3], expected: 2 },
    { nums1: [4, 5, 6], nums2: [], expected: 5 },
    { nums1: [2], nums2: [], expected: 2 },
    { nums1: [], nums2: [2], expected: 2 }
  ].freeze

  %i[find_median_sorted_arrays_v1].each do |method_name|
    describe method_name.to_s do
      test_cases.each do |test_case|
        it "Should return #{test_case[:expected]} for nums1 = #{test_case[:nums1]} and nums2 = #{test_case[:nums2]}" do
          result = send(method_name, test_case[:nums1], test_case[:nums2])
          assert_equal(test_case[:expected], result)
        end
      end
    end
  end
end
