# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0739_daily_temperatures/solution'

TEST_CASES = [
  { temps: [73, 74, 75, 71, 69, 72, 76, 73], expected: [1, 1, 4, 2, 1, 1, 0, 0] },
  { temps: [30, 40, 50, 60], expected: [1, 1, 1, 0] },
  { temps: [30, 60, 90], expected: [1, 1, 0] }
].freeze

%i[daily_temperatures_v1
   daily_temperatures_v2].each do |method_name|
  describe method_name.to_s do
    TEST_CASES.each do |tc|
      it "returns #{tc[:expected]} for #{tc[:temps]}" do
        result = send(method_name, tc[:temps])
        assert_equal(tc[:expected], result)
      end
    end
  end
end
