#!/usr/bin/env ruby
# frozen_string_literal: true

require 'optparse'
require 'pathname'
require 'fileutils'

options = {}
OptionParser.new do |parser|
  parser.banner = 'Usage: ruby scaffold.rb [options]'

  parser.on('-t', '--title TITLE', "Title of a LeetCode problem (e.g., '1. Two Sum')")
  parser.on('-u', '--url URL', 'URL of the LeetCode problem')

  parser.on('-h', '--help', 'Prints this help') do
    puts parser
    exit
  end
end.parse!(into: options)

abort('URL is invalid') unless options[:url].start_with?('https')

def format_dir_name(title)
  num_str, name_str = title.split('.', 2)
  num = num_str.to_i
  name = name_str.strip.downcase.gsub(' ', '_')
  format('s%<num>04d_%<name>s', num: num, name: name)
end

dir_name = format_dir_name(options[:title])

root_dir = Pathname.pwd.join('ruby')
lib_path = root_dir.join('lib', dir_name)
test_path = root_dir.join('test', dir_name)

FileUtils.mkdir_p(lib_path)
FileUtils.mkdir_p(test_path)

note_path = lib_path.join('note.md')
unless note_path.exist?
  note_path.write(<<~MD)
    [#{options[:title]}](#{options[:url]})
  MD
end

solution_path = lib_path.join('solution.rb')
unless solution_path.exist?
  solution_path.write(<<~RUBY)
    def __solution__()
    end
  RUBY
end

test_file_path = test_path.join('solution_test.rb')
unless test_file_path.exist?
  test_file_path.write(<<~RUBY)
    require 'minitest/autorun'
    require_relative '../../lib/#{dir_name}/solution'

    describe "v1" do
      it "" do
      end
    end
  RUBY
end
