while getopts "f:s:y:" opt; do
case $opt in
f ) F=$OPTARG;;
s ) S=$OPTARG;;
y ) Y=$OPTARG;;

\?) echo "Invalid option: -$OPTARG"
exit 1;; esac
done



if test ! -z "$F" ;                #  Try a string-length test.
then


if test -z "$S"  && test -z "$Y";
then
awk -F"|" '{ print $3 "|" $1 "|" $2 "|" $4 }' < $F | awk -F"|" '{ {sum+=$1}{count+=1} } END{ if (count==0){ print "Zero film matches the conditions." } else { print "the average gross sales of all films in '$F' category: " sum/count "\n" } }'
fi

if [ ! -z "$S" ] && [ -z "$Y" ]
then
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < $F | awk -F"|" '{ if ($3~/'$S'/) { {sum+=$1} {count+=1} } }
END{ if (count==0){ print "Zero film matches the conditions." } else { print "Average gross of the filmes made by '$S' of type '$F': " sum/count "\n" } }'
fi

if [ ! -z "$Y" ] && [ -z "$S" ]
then
sup=`expr $Y + 9`
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < $F | awk -F"|" '{ if ($4>='$Y'&&$4<='$sup') { {sum+=$1} {count+=1} } }
END{ 
if (count==0){ print "Zero film matches the conditions." }
else { print "the average gross sales of films made during '$Y's in '$F' category: " sum/count "\n" } }'
fi

if [ ! -z "$Y" ] && [ ! -z "$S" ]
then
sup=`expr $Y + 9`
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < $F | awk -F"|" '{ if ($3~/'$S'/&&$4>='$Y'&&$4<='$sup') {
{ {sum+=$1}{count+=1} } 
} 
}
END{
if (count==0){ print "Zero film matches the conditions." }
else { print "the average gross sales of films made by '$S' during '$Y's in '$F' category: " sum/count "\n" }
}'


fi


else
echo "ERROR! No input file name provided."

fi





