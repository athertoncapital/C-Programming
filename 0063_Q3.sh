if [ ! -z "$1" ]
then
#G
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < G.txt | sort -nr | awk -F"\
|" 'BEGIN { print "Average gross in G category of the top '$1' ranked filmes:  " } NR<='$1'{ {sum+=$1} {count+=1}  }
END{
if (count==0){ print "Zero film matches the conditions." }
else { print "Average gross: " sum/count "\n" } }'
#R
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < R.txt | sort -nr | awk -F"\
|" 'BEGIN { print "Average gross in R category of the top '$1' ranked filmes:  " } NR<='$1'{ {sum+=$1} {count+=1}  }
END{
if (count==0){ print "Zero film matches the conditions." }
else { print "Average gross: " sum/count "\n" } }'
#PG
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < PG.txt | sort -nr | awk -F"\
|" 'BEGIN { print "Average gross in PG category of the top '$1' ranked filmes:  " } NR<='$1'{ {sum+=$1} {count+=1}  }
END{
if (count==0){ print "Zero film matches the conditions." }
else { print "Average gross: " sum/count "\n" } }'
#PG-13
awk -F"|" '{ print $3 "|" $1"|" $2"|" $4 }' < PG-13.txt | sort -nr | awk -F"\
|" 'BEGIN { print "Average gross in PG-13 category of the top '$1' ranked filmes:  " } NR<='$1'{ {sum+=$1} {count+=1}  }
END{
if (count==0){ print "Zero film matches the conditions." }
else { print "Average gross: " sum/count "\n" } }'




else 
echo "ERROR!"
fi