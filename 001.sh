##!/bin/bash
#escho "Hello world!"
#emacs test.java

awk -F":" '{ if ( $1 ~ /[a-z]/ ) { print $3 } }' /etc/passwd