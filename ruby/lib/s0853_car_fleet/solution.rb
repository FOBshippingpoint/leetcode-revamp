# frozen_string_literal: true

# @param {Integer} target
# @param {Integer[]} position
# @param {Integer[]} speed
# @return {Integer}
def car_fleet_v1(target, position, speed)
  stack = []
  position.zip(speed).sort_by(&:first).reverse_each do |pos, spd|
    stack << (target - pos).fdiv(spd)
    stack.pop if stack.size >= 2 && stack.last <= stack[-2]
  end
  stack.size
end

# @param {Integer} target
# @param {Integer[]} position
# @param {Integer[]} speed
# @return {Integer}
def car_fleet_v2(target, position, speed)
  stack = []
  position.zip(speed).sort_by(&:first).reverse_each do |pos, spd|
    stack << Rational(target - pos, spd)
    stack.pop if stack.size >= 2 && stack.last <= stack[-2]
  end
  stack.size
end

# @param {Integer} target
# @param {Integer[]} position
# @param {Integer[]} speed
# @return {Integer}
def car_fleet_v3(target, position, speed)
  stack = []
  position.zip(speed).sort_by(&:first).reverse_each do |pos, spd|
    dest_time = (target - pos).fdiv(spd)
    stack << dest_time if stack.empty? || dest_time > stack.last
  end
  stack.size
end

# @param {Integer} target
# @param {Integer[]} position
# @param {Integer[]} speed
# @return {Integer}
def car_fleet_v4(target, position, speed)
  fleets = 0
  max_time = 0

  position.zip(speed).sort_by(&:first).reverse_each do |pos, spd|
    time = (target - pos).fdiv(spd)
    # Update slowest arrival fleet
    if time > max_time
      max_time = time
      fleets += 1
    end
  end
  fleets
end
