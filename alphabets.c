/*alphabets.c
 Author: William Huanshan Chuang
 ID: whchuang
 Created by ChuangWilliam H on 9/2/15.*/

#include <stdio.h>
int main()
{
    int c, i;
    int h[26];
    for (i=0;i<26;i++)
        h[i] = 0;
    
    while ((c=getchar())!=EOF){
        if (c=='a')
            h[c-'a']++;
        else if (c=='A')
            h[c-'A']++;
        else if (c=='b')
            h[c-'b'+1]++;
        else if (c=='B')
            h[c-'B'+1]++;
        else if (c=='c')
            h[c-'c'+2]++;
        else if (c=='C')
            h[c-'C'+2]++;
        else if (c=='d')
            h[c-'d'+3]++;
        else if (c=='D')
            h[c-'D'+3]++;
        else if (c=='e')
            h[c-'e'+4]++;
        else if (c=='E')
            h[c-'E'+4]++;
        else if (c=='f')
            h[c-'f'+5]++;
        else if (c=='F')
            h[c-'F'+5]++;
        else if (c=='g')
            h[c-'g'+6]++;
        else if (c=='G')
            h[c-'G'+6]++;
        else if (c=='h')
            h[c-'h'+7]++;
        else if (c=='H')
            h[c-'H'+7]++;
        else if (c=='i')
            h[c-'i'+8]++;
        else if (c=='I')
            h[c-'I'+8]++;
        else if (c=='j')
            h[c-'j'+9]++;
        else if (c=='J')
            h[c-'J'+9]++;
        else if (c=='k')
            h[c-'k'+10]++;
        else if (c=='K')
            h[c-'K'+10]++;
        else if (c=='l')
            h[c-'l'+11]++;
        else if (c=='L')
            h[c-'L'+11]++;
        else if (c=='M')
            h[c-'M'+12]++;
        else if (c=='m')
            h[c-'m'+12]++;
        else if (c=='n')
            h[c-'n'+13]++;
        else if (c=='N')
            h[c-'N'+13]++;
        else if (c=='o')
            h[c-'o'+14]++;
        else if (c=='O')
            h[c-'O'+14]++;
        else if (c=='p')
            h[c-'p'+15]++;
        else if (c=='P')
            h[c-'P'+15]++;
        else if (c=='q')
            h[c-'q'+16]++;
        else if (c=='Q')
            h[c-'Q'+16]++;
        else if (c=='r')
            h[c-'r'+17]++;
        else if (c=='R')
            h[c-'R'+17]++;
        else if (c=='s')
            h[c-'s'+18]++;
        else if (c=='S')
            h[c-'S'+18]++;
        else if (c=='t')
            h[c-'t'+19]++;
        else if (c=='T')
            h[c-'T'+19]++;
        else if (c=='u')
            h[c-'u'+20]++;
        else if (c=='U')
            h[c-'U'+20]++;
        else if (c=='v')
            h[c-'v'+21]++;
        else if (c=='V')
            h[c-'V'+21]++;
        else if (c=='w')
            h[c-'w'+22]++;
        else if (c=='W')
            h[c-'W'+22]++;
        else if (c=='x')
            h[c-'x'+23]++;
        else if (c=='X')
            h[c-'X'+23]++;
        else if (c=='y')
            h[c-'y'+24]++;
        else if (c=='Y')
            h[c-'Y'+24]++;
        else if (c=='z')
            h[c-'z'+25]++;
        else if (c=='Z')
            h[c-'Z'+25]++;
    }
    printf("\n%d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d\n",h[0],h[1],h[2],h[3],h[4],h[5],h[6],h[7],h[8],h[9],h[10],h[11],h[12],h[13],h[14],h[15],h[16],h[17],h[18],h[19],h[20],h[21],h[22],h[23],h[24],h[25]);
}
