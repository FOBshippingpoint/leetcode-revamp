# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0021_merge_two_sorted_lists/solution'

def array_to_list(values)
  values.reverse.inject(nil) { |next_node, val| ListNode.new(val, next_node) }
end

def list_to_array(head)
  result = []
  while head
    result << head.val
    head = head.next
  end
  result
end

%i[merge_two_lists_v1 merge_two_lists_v2].each do |method_name|
  test_cases = [
    { list1: [1, 2, 4], list2: [1, 3, 4], expected: [1, 1, 2, 3, 4, 4] },
    { list1: [], list2: [], expected: [] },
    { list1: [], list2: [0], expected: [0] }
  ].freeze

  describe method_name.to_s do
    test_cases.each do |tc|
      it "returns #{tc[:expected]} for list1=#{tc[:list1]}, list2=#{tc[:list2]}" do
        list1 = array_to_list(tc[:list1])
        list2 = array_to_list(tc[:list2])
        result = send(method_name, list1, list2)
        assert_equal(tc[:expected], list_to_array(result))
      end
    end
  end
end
