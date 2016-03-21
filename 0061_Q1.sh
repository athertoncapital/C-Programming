#! /bin/sh
awk -F"|" '{ printf $3 "|" $1 "\n" }' < $2 | sort -nr | awk -F"|" 'NR=='$1'{ printf $2 "\n" }' 










