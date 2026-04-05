# frozen_string_literal: true

# @param {String} s
# @param {Integer} k
# @return {Integer}
def character_replacement(s, k)
  head = 0
  longest = 0
  freq_map = Hash.new(0)
  max_freq = 0

  s.each_char.with_index do |tail_ch, tail|
    freq_map[tail_ch] += 1
    max_freq = [max_freq, freq_map[tail_ch]].max
    while (tail - head + 1) - max_freq > k
      freq_map[s[head]] -= 1
      head += 1
    end
    longest = [longest, tail - head + 1].max
  end
  longest
end
