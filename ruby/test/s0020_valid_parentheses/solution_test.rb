# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0020_valid_parentheses/solution'

describe 'valid parentheses' do
  test_cases = [
    { s: '()',     expected: true },
    { s: '()[]{}', expected: true },
    { s: '(]',     expected: false },
    { s: '([])',   expected: true },
    { s: '([)]',   expected: false }
  ].freeze

  %i[is_valid_v1 is_valid_v2 is_valid_v3].each do |method_name|
    describe method_name.to_s do
      test_cases.each do |test_case|
        it "Should return #{test_case[:expected]} for s = '#{test_case[:s]}'" do
          result = send(method_name, test_case[:s])
          assert_equal(test_case[:expected], result, "Failed on method #{method_name} with s = #{test_case[:s]}")
        end
      end
    end
  end
end
