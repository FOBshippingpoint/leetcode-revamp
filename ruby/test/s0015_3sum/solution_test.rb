# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0015_3sum/solution'

describe 'v1' do
  it 'Should return [[-1,-1,2],[-1,0,1]] for [-1,0,1,2,-1,-4]' do
    nums = [-1, 0, 1, 2, -1, -4]
    result = three_sum_v1(nums)
    expected = [[-1, -1, 2], [-1, 0, 1]]
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should return [] for [0,1,1]' do
    nums = [0, 1, 1]
    result = three_sum_v1(nums)
    expected = []
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should return [[0,0,0]] for [0,0,0]' do
    nums = [0, 0, 0]
    result = three_sum_v1(nums)
    expected = [[0, 0, 0]]
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should return [[0,0,0]] for [1,2,0,1,0,0,0,0]' do
    nums = [1, 2, 0, 1, 0, 0, 0, 0]
    result = three_sum_v1(nums)
    expected = [[0, 0, 0]]
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end
end
