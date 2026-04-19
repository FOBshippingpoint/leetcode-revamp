# frozen_string_literal: true

# A object of class \ListNode represents a node
# of singly-linked list.
class ListNode
  attr_accessor :val, :next

  def initialize(val = 0, _next = nil) # rubocop:disable Lint/UnderscorePrefixedVariableName
    @val = val
    @next = _next
  end
end

# @param {ListNode} head
# @return {ListNode}
def reverse_list_v1(head)
  prev = nil
  curr = head

  until curr.nil?
    nxt = curr.next
    curr.next = prev
    prev = curr
    curr = nxt
  end

  prev
end

# @param {ListNode} head
# @return {ListNode}
def reverse_list_v2(head)
  return head if head.nil? || head.next.nil?

  new_head = reverse_list_v2(head.next)
  head.next.next = head
  head.next = nil

  new_head
end
