# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0217_contains_duplicate/solution'

describe 'v1' do
  it 'Should be duplicates since the element 1 occurs at the indices 0 and 3' do
    nums = [1, 2, 3, 1]
    result = contains_duplicate_v1(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should not be duplicates since All elements are distinct' do
    nums = [1, 2, 3, 4]
    result = contains_duplicate_v1(nums)
    expected = false
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should be duplicates since the element 1 occurs at the indices 0 and 1' do
    nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    result = contains_duplicate_v1(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end
end

describe 'v2' do
  it 'Should be duplicates since the element 1 occurs at the indices 0 and 3' do
    nums = [1, 2, 3, 1]
    result = contains_duplicate_v2(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should not be duplicates since All elements are distinct' do
    nums = [1, 2, 3, 4]
    result = contains_duplicate_v2(nums)
    expected = false
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should be duplicates since the element 1 occurs at the indices 0 and 1' do
    nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    result = contains_duplicate_v2(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end
end

describe 'v3' do
  it 'Should be duplicates since the element 1 occurs at the indices 0 and 3' do
    nums = [1, 2, 3, 1]
    result = contains_duplicate_v3(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should not be duplicates since All elements are distinct' do
    nums = [1, 2, 3, 4]
    result = contains_duplicate_v3(nums)
    expected = false
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end

  it 'Should be duplicates since the element 1 occurs at the indices 0 and 1' do
    nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    result = contains_duplicate_v3(nums)
    expected = true
    assert_equal(expected, result, "nums = #{nums.inspect}")
  end
end
