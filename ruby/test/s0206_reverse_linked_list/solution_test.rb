# frozen_string_literal: true

require 'minitest/autorun'
require_relative '../../lib/s0206_reverse_linked_list/solution'

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

%i[reverse_list_v1 reverse_list_v2].each do |method_name|
  test_cases = [
    { head: [1, 2, 3, 4, 5], expected: [5, 4, 3, 2, 1] },
    { head: [1, 2], expected: [2, 1] },
    { head: [], expected: [] }
  ].freeze

  describe method_name.to_s do
    test_cases.each do |tc|
      it "returns #{tc[:expected]} for head=#{tc[:head]}" do
        head = array_to_list(tc[:head])
        result = send(method_name, head)
        assert_equal(tc[:expected], list_to_array(result))
      end
    end
  end
end
