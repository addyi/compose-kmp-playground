#!/bin/bash

printf "Running dependency locking script\n\n"

MODULES=(
  ''
  'shared'
  'androidApp'
  'buildSrc'
)

ROOT=$(git rev-parse --show-toplevel) # get project root dir

RED_BOLD="\033[1;31m"
RESET_FORMAT="\033[m"

fail() {
  printf "Dependency locking failed because:${RED_BOLD} %s ${RESET_FORMAT}\n" "$1" >&2
  exit 1
}

# check and setup preconditions
cd "$ROOT" || fail "Git is not installed"

[ -e gradlew ] || fail "gradlew doesn't exist"
[ -x gradlew ] || fail "gradlew isn't executable"

# Delete all gradle.lockfile
printf "Deleting all lockfile\n\n"
find "$ROOT" -type f -name "*gradle.lockfile" -delete

# Only delete locking files if delete flag is defined
if [ "$1" = "--delete" ]; then exit 0; fi

# Create lockfile for modules
for i in "${MODULES[@]}"; do
  printf "Create lockfile for \"%s\"\n" "$i"

  ./gradlew "$i:dependencies" --write-locks >/dev/null 2>/dev/null # redirect stdout/stderr to prevent output

  # check exit code of gradle task
  RESULT=$?
  [ $RESULT -ne 0 ] && fail "Could not write lockfile for \"$i\""
done

exit 0
