#!/bin/sh

script_name=${0##*/}
script_dir=$(cd "$(dirname "$0")" >/dev/null 2>&1 && pwd -P)

usage() {
	cat <<USAGE
Usage: $script_name [-h|--help] [-m|--meta metadata] [-l|--language language]

Create leetcode scaffold for specified language

Available options:

-h, --help          Print this help and exit


Description:
USAGE
	exit
}

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
metadata=
language=

while :; do
	case $1 in
	-h | --help)
		usage
		;;
	-m | --meta)
		metadata=${2:-}
		if [ ! "$metadata" ]; then
			die "--meta requires a value"
		fi
		;;
	-l | --language)
		language=${2:-}
		if [ ! "$language" ]; then
			die "--language requires a value"
		fi
		;;
	-*)
		die "Unknown option [ $1 ]"
		;;
	*) break ;;
	esac
	shift
done

while IFS= read -r line; do
	i=$((i + 1))
	case $i in
	1) human_name=$line ;;
	2) directory_name=$line ;;
	3) url=$line ;;
	*) break ;;
	esac
done <<EOF
$metadata
EOF

if [ "$i" != 3 ]; then
	die "Expecting metadata line count to be 3, got [ $i ]
Try following:
  217. Contains Duplicate
  0217_contains_duplicate
  https://leetcode.com/problems/contains-duplicate/
"
fi

if [ ! "$language" ]; then
	printf '%s' "Choose language: "
	read -r language
fi

cd "$script_dir" || die
cd .. || die
mkdir -p "$language" || die
cd "$language" || die
mkdir -p "$directory_name" || die

if [ -f "$directory_name/note.md" ]; then
	die "note.md already exists in [ $directory_name/note.md ]"
fi

printf '%s' "# [$human_name]($url)" >"$directory_name/note.md"

msg "[ $(readlink -f "$directory_name/note.md") ] scaffold created"
