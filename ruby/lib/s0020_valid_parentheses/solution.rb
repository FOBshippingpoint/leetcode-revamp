# frozen_string_literal: true

# @param {String} s
# @return {Boolean}
def is_valid(s)
  paren = { '(' => ')', '{' => '}', '[' => ']' }

  stack = []
  s.each_char do |char|
    if paren.key?(char)
      stack << char
    elsif paren.value?(char)
      return false if paren[stack.pop] != char
    end
  end

  stack.empty?
end
