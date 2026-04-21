# frozen_string_literal: true

# Definition for singly-linked list.
class ListNode
  attr_accessor :val, :next

  def initialize(val = 0, _next = nil) # rubocop:disable Lint/UnderscorePrefixedVariableName
    @val = val
    @next = _next
  end
end

# @param {ListNode} list1
# @param {ListNode} list2
# @return {ListNode}
def merge_two_lists_v1(list1, list2)
  head, big = cmp_node(list1, list2)
  curr = head
  until curr.nil?
    small, big = cmp_node(curr.next, big)
    curr.next = small
    curr = small
  end
  head
end

# Compares two nodes and returns them in ascending order.
#
# @param node1 [ListNode, nil] The first node to compare.
# @param node2 [ListNode, nil] The second node to compare.
# @return [Array(ListNode, ListNode), Array(nil, nil)] A tuple containing [smaller_node, larger_node].
def cmp_node(node1, node2)
  return nil, nil if node1.nil? && node2.nil?
  return node2, node1 if node1.nil?
  return node1, node2 if node2.nil?

  node1.val <= node2.val ? [node1, node2] : [node2, node1]
end

# @param {ListNode} list1
# @param {ListNode} list2
# @return {ListNode}
def merge_two_lists_v2(list1, list2)
  dummy = ListNode.new(nil)
  curr = dummy

  while list1 && list2
    if list1.val < list2.val
      curr.next = list1
      list1 = list1.next
    else
      curr.next = list2
      list2 = list2.next
    end
    curr = curr.next
  end
  # Append remaining nodes
  curr.next = list1 || list2

  dummy.next
end
