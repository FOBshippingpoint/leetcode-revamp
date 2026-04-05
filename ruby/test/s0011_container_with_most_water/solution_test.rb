# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0011_container_with_most_water/solution'

describe 'v1' do
  it 'Should return 49 for height [1,8,6,2,5,4,8,3,7]' do
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    result = max_area(height)
    expected = 49
    assert_equal(expected, result, "height = #{height}")
  end

  it 'Should return 1 for height [1,1]' do
    height = [1, 1]
    result = max_area(height)
    expected = 1
    assert_equal(expected, result, "height = #{height}")
  end
end
