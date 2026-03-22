#!/bin/sh

msg() {
	IFS=" $IFS"
	set -- '%s\n' "${*:-}"
	IFS=${IFS#?}
	# shellcheck disable=SC2059
	printf "$@"
}

die() {
	[ "${1:-}" ] && msg "$1"
	exit "${2:-1}"
}

script_dir=$(dirname "$0")
cd "$script_dir/.." || exit 1

i=0
human_name=
directory_name=
url=

while IFS= read -r line; do
	i=$((i + 1))
	case $i in
	1) human_name=$line ;;
	2) directory_name=$line ;;
	3) url=$line ;;
	*) break ;;
	esac
done

if [ "$i" != 3 ]; then
	die "Parameters count not match, expecting 3, got [ $i ]
Try input:
  217. Contains Duplicate
  217_contains_duplicate
  https://leetcode.com/problems/contains-duplicate/
"
fi

if ! mkdir "problems/$directory_name"; then
	die "[ problems/$directory_name ] already exists"
fi

printf '%s' "# [$human_name]($url)" >"problems/$directory_name/problem.md"
