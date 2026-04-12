# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0853_car_fleet/solution'

%i[car_fleet_v1
   car_fleet_v2
   car_fleet_v3
   car_fleet_v4].each do |method_name|
  describe method_name.to_s do
    test_cases = [
      { target: 12, position: [10, 8, 0, 5, 3], speed: [2, 4, 1, 1, 3], expected: 3 },
      { target: 10, position: [3], speed: [3], expected: 1 },
      { target: 100, position: [0, 2, 4], speed: [4, 2, 1], expected: 1 }
    ].freeze

    test_cases.each do |tc|
      it "returns #{tc[:expected]} for target=#{tc[:target]}, pos=#{tc[:position]}, spd=#{tc[:speed]}" do
        result = send(method_name, tc[:target], tc[:position], tc[:speed])
        assert_equal(tc[:expected], result)
      end
    end
  end
end
