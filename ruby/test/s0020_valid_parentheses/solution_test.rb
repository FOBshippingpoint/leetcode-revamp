# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0020_valid_parentheses/solution'

describe 'v1' do
  it 'Should return true for s = "()"' do
    s = '()'
    result = is_valid(s)
    expected = true
    assert_equal(expected, result, "s = #{s}")
  end

  it 'Should return true for s = "()[]{}"' do
    s = '()[]{}'
    result = is_valid(s)
    expected = true
    assert_equal(expected, result, "s = #{s}")
  end

  it 'Should return false for s = "(]"' do
    s = '(]'
    result = is_valid(s)
    expected = false
    assert_equal(expected, result, "s = #{s}")
  end

  it 'Should return true for s = "([])"' do
    s = '([])'
    result = is_valid(s)
    expected = true
    assert_equal(expected, result, "s = #{s}")
  end

  it 'Should return false for s = "([)]"' do
    s = '([)]'
    result = is_valid(s)
    expected = false
    assert_equal(expected, result, "s = #{s}")
  end
end
