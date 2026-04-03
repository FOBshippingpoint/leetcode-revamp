# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0242_valid_anagram/solution'

describe 'v1' do
  it 'Should be anagram since the chars type and count match' do
    s = 'anagram'
    t = 'nagaram'
    result = is_anagram_v1(s, t)
    expected = true
    assert_equal(expected, result, "s = #{s}, t = #{t}")
  end

  it 'Should not be anagram since the char t and c are not equal' do
    s = 'rat'
    t = 'car'
    result = is_anagram_v1(s, t)
    expected = false
    assert_equal(expected, result, "s = #{s}, t = #{t}")
  end
end

describe 'v2' do
  it 'Should be anagram since the chars type and count match' do
    s = 'anagram'
    t = 'nagaram'
    result = is_anagram_v2(s, t)
    expected = true
    assert_equal(expected, result, "s = #{s}, t = #{t}")
  end

  it 'Should not be anagram since the char t and c are not equal' do
    s = 'rat'
    t = 'car'
    result = is_anagram_v2(s, t)
    expected = false
    assert_equal(expected, result, "s = #{s}, t = #{t}")
  end
end
