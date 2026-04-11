# frozen_string_literal: true

Pair = Data.define(:temp, :index)

# @param {Integer[]} temperatures
# @return {Integer[]}
def daily_temperatures_v1(temperatures)
  stack = []
  result = Array.new(temperatures.size, 0)

  temperatures.each_with_index do |temp, i|
    while !stack.empty? && stack.last.temp < temp
      p = stack.pop
      result[p.index] = (i - p.index)
    end
    stack << Pair.new(temp, i)
  end
  result
end

# @param {Integer[]} temperatures
# @return {Integer[]}
def daily_temperatures_v2(temperatures)
  stack = []
  result = Array.new(temperatures.size, 0)

  temperatures.each_with_index do |temp, i|
    while !stack.empty? && temperatures[stack.last] < temp
      prev_i = stack.pop
      result[prev_i] = (i - prev_i)
    end
    stack << i
  end
  result
end
