# frozen_string_literal: true

# @param {String} s1
# @param {String} s2
# @return {Boolean}
def check_inclusion_v1(s1, s2)
  freq = Hash.new(0)
  s1.each_char { |char| freq[char] += 1 }

  head = 0
  s2.each_char.with_index do |s2_char, tail|
    freq[s2_char] -= 1
    while freq[s2_char].negative?
      freq[s2[head]] += 1
      head += 1
    end
    return true if tail - head + 1 == s1.size
  end
  false
end
