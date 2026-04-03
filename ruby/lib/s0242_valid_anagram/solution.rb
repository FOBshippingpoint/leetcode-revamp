# frozen_string_literal: true

# @param {String} s
# @param {String} t
# @return {Boolean}
def is_anagram_v1(s, t)
  s.chars.tally == t.chars.tally
end

# @param {String} s
# @param {String} t
# @return {Boolean}
def is_anagram_v2(s, t)
  return false if s.size != t.size

  occur = Hash.new(0)

  s.each_char do |char|
    occur[char] += 1
  end

  t.each_char do |char|
    occur[char] -= 1
    return false if occur[char].negative?
  end

  true
end
