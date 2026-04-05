# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0424_longest_repeating_character_replacement/solution'

describe 'v1' do
  it 'Should return 4 for s = "ABAB", k = 2' do
    s = 'ABAB'
    k = 2
    result = character_replacement(s, k)
    expected = 4
    assert_equal(expected, result, "s = #{s}, k = #{k}")
  end

  it 'Should return 4 for s = "AABABBA", k = 1' do
    s = 'AABABBA'
    k = 1
    result = character_replacement(s, k)
    expected = 4
    assert_equal(expected, result, "s = #{s}, k = #{k}")
  end
end
