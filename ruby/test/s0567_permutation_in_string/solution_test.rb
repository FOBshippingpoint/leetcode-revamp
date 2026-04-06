# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0567_permutation_in_string/solution'

describe 'v1' do
  it 'Should return true for s1 = "ab", s2 = "eidbaooo"' do
    s1 = 'ab'
    s2 = 'eidbaooo'
    result = check_inclusion_v1(s1, s2)
    expected = true
    assert_equal(expected, result, "s1 = #{s1}, s2 = #{s2}")
  end

  it 'Should return false for s1 = "ab", s2 = "eidboaoo"' do
    s1 = 'ab'
    s2 = 'eidboaoo'
    result = check_inclusion_v1(s1, s2)
    expected = false
    assert_equal(expected, result, "s1 = #{s1}, s2 = #{s2}")
  end
end
