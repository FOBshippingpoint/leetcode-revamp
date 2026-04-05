# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0042_trapping_rain_water/solution'

describe 'v1' do
  it 'Should trap 6 units of rain water for height [0,1,0,2,1,0,1,3,2,1,2,1]' do
    height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = trap_v1(height)
    expected = 6
    assert_equal(expected, result, "height = #{height}")
  end

  it 'Should trap 9 units of rain water for height [4,2,0,3,2,5]' do
    height = [4, 2, 0, 3, 2, 5]
    result = trap_v1(height)
    expected = 9
    assert_equal(expected, result, "height = #{height}")
  end

  it 'Should trap 9 units of rain water for height [0,2,0,3,1,0,1,3,2,1]' do
    height = [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]
    result = trap_v1(height)
    expected = 9
    assert_equal(expected, result, "height = #{height}")
  end
end
