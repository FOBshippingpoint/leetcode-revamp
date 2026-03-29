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

title=
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

IFS= read -r title url _nope <<EOF
$metadata
EOF

if [ "${nope:-}" ]; then
	die "Expecting metadata line count to be 2
Try following:
  217. Contains Duplicate
  https://leetcode.com/problems/contains-duplicate/
"
fi

if [ ! "$language" ]; then
	printf '%s' "Choose language: "
	read -r language
fi

case $language in
  go)
    go run scaffold.go -- "$url" -title "$title" -url "$url"
  ;;
  java)
    java Scaffold.java
  ;;
  *)
    die "Language [ $language ] is not supported"
  ;;
esac
