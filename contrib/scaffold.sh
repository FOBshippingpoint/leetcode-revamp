#!/bin/sh

script_name=${0##*/}
script_dir=$(cd "$(dirname "$0")" >/dev/null 2>&1 && pwd -P)

usage() {
	cat <<USAGE
Usage:

$script_name -h|--help
$script_name (-u|--url) URL (-t|--title) TITLE [-l|--language LANGUAGE]

Description:

Create leetcode scaffold for specified language

Available options:

-h, --help          Print this help and exit
-t, --title         Title of a LeetCode problem (e.g., '1. Two Sum')
-u, --url           URL of the LeetCode problem (e.g., 'https://leetcode.com/problems/two-sum/')
-l, --language      Language to scaffold:
                      go
                      java
                      ruby
USAGE
	exit
}

# https://github.com/dylanaraps/pure-sh-bible?tab=readme-ov-file#trim-leading-and-trailing-white-space-from-string
trim() {
	trim=${1#${1%%[![:space:]]*}}
	trim=${trim%${trim##*[![:space:]]}}
	printf '%s\n' "$trim"
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

cd "$script_dir/.." || exit 1

title=
url=

language=

while :; do
	case $1 in
	-h | --help)
		usage
		;;
	-t | --title)
		title=${2:-}
		if [ ! "$title" ]; then
			die "--title requires a value"
		fi
    shift
		;;
	-u | --url)
		url=${2:-}
		if [ ! "$url" ]; then
			die "--url requires a value"
		fi
    shift
		;;
	-l | --language)
		language=${2:-}
		if [ ! "$language" ]; then
			die "--language requires a value"
		fi
    shift
		;;
	-*)
		die "Unknown option [ $1 ]"
		;;
	*) break ;;
	esac
	shift
done

if [ ! "$title" ]; then
	printf '%s' "LeetCode problem title: "
	read -r title
fi

if [ ! "$url" ]; then
	printf '%s' "LeetCode problem URL: "
	read -r url
fi

if [ ! "$language" ]; then
	printf '%s' "Choose language: "
	read -r language
fi

case $language in
go)
	(
		set -x
		go run contrib/scaffold.go -title "$title" -url "$url"
	)
	;;
java)
	(
		set -x
		java --enable-preview --source 25 contrib/Scaffold.java --title "$title" --url "$url"
	)
	;;
ruby)
	(
		set -x
		ruby contrib/scaffold.rb --title "$title" --url "$url"
	)
	;;
*)
	die "Language [ $language ] is not supported"
	;;
esac
