# frozen_string_literal: true

# @param {String} s
# @return {Boolean}
def is_valid_v1(s)
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

# @param {String} s
# @return {Boolean}
def is_valid_v2(s)
  stack = []
  s.each_char do |char|
    case char
    when '('
      stack << ')'
    when '{'
      stack << '}'
    when '['
      stack << ']'
    when ')', '}', ']'
      return false if stack.pop != char
    end
  end

  stack.empty?
end

# @param {String} s
# @return {Boolean}
def is_valid_v3(s)
  stack = []
  paren = { '(' => ')', '{' => '}', '[' => ']' }

  s.each_char do |char|
    if paren.key?(char)
      stack << paren[char]
    elsif stack.pop != char
      return false
    end
  end

  stack.empty?
end
