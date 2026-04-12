# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0704_binary_search/solution'

%i[search_v1 search_v2 search_v3].each do |method_name|
  test_cases = [
    { nums: [-1, 0, 3, 5, 9, 12], target: 9, expected: 4 },
    { nums: [-1, 0, 3, 5, 9, 12], target: 2, expected: -1 }
  ].freeze

  describe method_name.to_s do
    test_cases.each do |tc|
      it "returns #{tc[:expected]} for nums=#{tc[:nums]}, target=#{tc[:target]}" do
        result = send(method_name, tc[:nums], tc[:target])
        assert_equal(tc[:expected], result)
      end
    end
  end
end
