# Problem 1
awk 'BEGIN { print "Problem 1:" }' #print on the console
awk 'BEGIN { print "Problem 1:" }' > out.txt #write to the output file
awk 'BEGIN { print "The following are the whole list. The sorting is based on the money each movie earned" }' #print on the console
awk 'BEGIN { print "The following are the whole list. The sorting is based on the money each movie earned" }'  >> out.txt
awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < alltime.txt | sort -nr #print on the console
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < alltime.txt | sort -nr  >> out.txt
awk 'BEGIN { printf "\n" }' #print on the console
awk 'BEGIN { printf "\n" }' >> out.txt #New line. 
awk 'BEGIN { printf "The following are movies with the top five earnings:" "\n" 
}'#print on the console
awk 'BEGIN { printf "The following are movies with the top five earnings:" "\n"
}' >> out.txt 
awk 'BEGIN { printf "\n" }'#print on the console
awk 'BEGIN { printf "\n" }'>> out.txt  #New line.
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < alltime.txt | sort -nr | awk -F"|" 'NR>=1&&NR<=5 { printf $1"|"$2"|"$3"|"$4 "\n" }' #print on the console
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < alltime.txt | sort -nr | awk -F"|" 'NR>=1&&NR<=5 { printf $1"|"$2"|"$3"|"$4 "\n" }' >> out.txt 
awk 'BEGIN { printf "\n" }' >> out.txt 
awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { print "Due to the above sorting, we could know that the top one are\: " 
printf "Top 1. Gone with the Wind" "\n"
}'>> out.txt
awk 'BEGIN { print "Due to the above sorting, we could know that the top one are\: " 
printf "Top 1. Gone with the Wind" "\n"
}'#print to the console 
awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { printf "\n" }' >>out.txt

# Problem 2
awk 'BEGIN { print "Problem 2:" }'>> out.txt 
awk 'BEGIN { print "Problem 2:" }'
awk 'BEGIN { print "The following are the whole list. The sorting is based on the money each movie earned" }' #print on the console
awk 'BEGIN { print "The following are the whole list. The sorting is based on the money each movie earned" }'  >> out.txt
awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr #print on the console
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr  >> out.txt
awk 'BEGIN { printf "\n" }' #print on the console
awk 'BEGIN { printf "\n" }' >> out.txt #New line. 
awk 'BEGIN { printf "The following is the 50th movie by gross on the list:" "\n" 
}'#print on the console
awk 'BEGIN { printf "The following is the 50th movie by gross on the list:" "\n"
}' >> out.txt 
awk 'BEGIN { printf "\n" }'#print on the console
awk 'BEGIN { printf "\n" }'>> out.txt  #New line.
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr | awk -F"|" 'NR==50 { printf $1 " " "|" " " $2 " " "|" " " $3 " " "|" " "$4 "\n" }' #print on the console
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr | awk -F"|" 'NR==50 { printf $1 " " "|" " " $2 " " "|" " " $3 " " "|" " "$4 "\n" }' >> out.txt 

awk 'BEGIN { printf "\n" }' >> out.txt 
awk 'BEGIN { printf "\n" }' 

# Problem 3
awk 'BEGIN { print "Problem 3:" }'>> out.txt 
awk 'BEGIN { print "Problem 3:" }' 
awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { printf "\n" }' >>out.txt

#step 1 sort with years
awk 'BEGIN { print "The following are the whole list (1970-1979). " }' #print on the console
awk 'BEGIN { print "The following are the whole list (1970-1979). " }'  >> out.txt
awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
awk -F"|" '{ 
if ($4 <= 1979&&$4>=1970) {
printf $4 "|" $1"|" $2"|" $3 "\n" } }' < alltime.txt | sort -n #print on the console
awk -F"|" '{ 
if ($4 <= 1979&&$4>=1970) {
printf $4 "|" $1"|" $2"|" $3 "\n" } }' < alltime.txt | sort -n  >> out.txt
awk 'BEGIN { printf "\n" }' #print on the console
awk 'BEGIN { printf "\n" }' >> out.txt #New line. 

awk 'BEGIN { print "The following are the whole list (1980-1989). " }' #print on the console
awk 'BEGIN { print "The following are the whole list (1980-1989). " }'  >> out.txt
awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
awk -F"|" '{ 
if ($4 <= 1989&&$4>=1980) {
printf $4 "|" $1"|" $2"|" $3 "\n" } }' < alltime.txt | sort -n #print on the console
awk -F"|" '{ 
if ($4 <= 1989&&$4>=1980) {
printf $4 "|" $1"|" $2"|" $3 "\n" } }' < alltime.txt | sort -n  >> out.txt
awk 'BEGIN { printf "\n" }' #print on the console
awk 'BEGIN { printf "\n" }' >> out.txt #New line. 

#step 2 choose the top 50 earnings and sum them all and compare the 70s and 80s
awk 'BEGIN { print "Here we compare two classifications:" "\n"}'
awk 'BEGIN { print "Here we compare two classifications:" "\n"}' >> out.txt

awk -F"|" '{ if ($4 <= 1979&&$4>=1970) 
{ printf $3 "|" $1"|" $2"|" $4 "\n" } }' < alltime.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of the earnings of 70s:" sum "\n" }'
awk -F"|" '{ if ($4 <= 1979&&$4>=1970) 
{ printf $3 "|" $1"|" $2"|" $4 "\n" } }' < alltime.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of the earnings of 70s:" sum "\n" }'>>out.txt
awk -F"|" '{ if ($4 <= 1989&&$4>=1980) 
{ printf $3 "|" $1"|" $2"|" $4 "\n" } }' < alltime.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of the earnings of 80s:" sum "\n" }'
awk -F"|" '{ if ($4 <= 1989&&$4>=1980) 
{ printf $3 "|" $1"|" $2"|" $4 "\n" } }' < alltime.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of the earnings of 80s:" sum "\n" }'>>out.txt

awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
awk 'BEGIN { print "After comparing the results of 70s and 80s, the answer is 70s." "\n"
}'>> out.txt
awk 'BEGIN { print "After comparing the results of 70s and 80s, the answer is 70s." "\n"
}'

awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { printf "\n" }' >>out.txt


# Problem 4
awk 'BEGIN { print "Problem 4:" }'>> out.txt 
awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { printf "\n" }' >>out.txt
awk 'BEGIN { print "Problem 4:" }' #print on the console
awk -F"|" '{ 
if ($4~/196[0-9]/) {
printf $2 "|" $1"|" $3"|" $4 "\n" } }' < alltime.txt | sort | awk -F"|" 'BEGIN {
print "Studio \tEarnings";
}
{
if ($1~/AVCO/) {AVC+=$3}
if ($1~/Col/) {Col+=$3}
if ($1~/Dis/) {Dis+=$3}
if ($1~/Fox/) {Fox+=$3}
if ($1~/MGM/) {MGM+=$3}
if ($1~/UA/) {UA+=$3}
if ($1~/Uni/) {Uni+=$3}
if ($1~/WB/) {WB+=$3}
}
END{
printf "AVCO: " "\t" AVC "\n";
printf "Col.: " "\t" Col "\n";
printf "Dis: " "\t" Dis "\n";
printf "Fox: " "\t" Fox "\n";
printf "MGM: " "\t" MGM "\n";
printf "UA: " "\t" UA "\n";
printf "Uni.: " "\t" Uni "\n";
printf "WB: " "\t" WB "\n";
}' | awk -F":" '{ print $2 "|" $1 }' | sort -n | awk -F"|" '{ print $2 $1 }'

awk -F"|" '{ 
if ($4~/196[0-9]/) {
printf $2 "|" $1"|" $3"|" $4 "\n" } }' < alltime.txt | sort | awk -F"|" 'BEGIN {
print "Studio \tEarnings";
}
{
if ($1~/AVCO/) {AVC+=$3}
if ($1~/Col/) {Col+=$3}
if ($1~/Dis/) {Dis+=$3}
if ($1~/Fox/) {Fox+=$3}
if ($1~/MGM/) {MGM+=$3}
if ($1~/UA/) {UA+=$3}
if ($1~/Uni/) {Uni+=$3}
if ($1~/WB/) {WB+=$3}
}
END{
printf "AVCO: " "\t" AVC "\n";
printf "Col.: " "\t" Col "\n";
printf "Dis: " "\t" Dis "\n";
printf "Fox: " "\t" Fox "\n";
printf "MGM: " "\t" MGM "\n";
printf "UA: " "\t" UA "\n";
printf "Uni.: " "\t" Uni "\n";
printf "WB: " "\t" WB "\n";
}' | awk -F":" '{ print $2 "|" $1 }' | sort -n | awk -F"|" '{ print $2 $1 }' >>out.txt

awk 'BEGIN { print "The best studio is Dis." }' #print on the console
awk 'BEGIN { print "The best studio is Dis." }'  >> out.txt
awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 


# Problem 5
awk 'BEGIN { print "Problem 5:" }' #print on the console
awk 'BEGIN { print "Problem 5:" }' >> out.txt #write to the output file
awk 'BEGIN { print "The rating method I use is to sum up all earnings of all films of each category, then compare the four numbers, and choose the largest one." }' #print on the console
awk 'BEGIN { print "The rating method I use is to sum up all earnings of all films of each category, then compare the four numbers, and choose the largest one." }' >>out.txt

awk 'BEGIN { printf "\n" }'  #print on the console
awk 'BEGIN { printf "\n" }'  >> out.txt #New line. 
#step 1 sum over G.txt
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < G.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type G:" sum "\n" }'>>out.txt
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < G.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type G:" sum "\n" }'

awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < PG.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type PG:" sum "\n" }'>>out.txt
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < PG.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type PG:" sum "\n" }'

awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < PG-13.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type PG-13:" sum "\n" }'>>out.txt
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < PG-13.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type PG-13:" sum "\n" }'

awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type R:" sum "\n" }'>>out.txt
awk -F"|" '{ printf $3 "|" $1"|" $2"|" $4 "\n" }' < R.txt | sort -nr | 
awk -F"|" 'BEGIN { print "" } 
{sum+=$1} 
END{ printf "Tot. of earning of type R:" sum "\n" }'


awk 'BEGIN { printf "Due to the above results of the four categories, I choose PG-13 for the film to make." "\n" }' 
awk 'BEGIN { printf "Due to the above results of the four categories, I choose PG-13 for the film to make." "\n" }' >>out.txt

awk 'BEGIN { printf "\n" }' 
awk 'BEGIN { printf "\n" }' >>out.txt