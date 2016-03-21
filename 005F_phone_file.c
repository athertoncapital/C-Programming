#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main (int argc, char *argv[] )
{
  char output[512]="output.txt";
  char input[512];
  if (argv[2]!='\0'){strcpy(output,argv[2]);}
  if (argv[1]=='\0') 
    {
	printf("Wrong way to excute the pogram, \n please enter the input file name,\n e.g., input.txt after the ./phones_file,\n and it's better to specify the output file name you prefer. \n But, please remember the max length of file name is less than or equal to 255 characters,\n and the limit of the file name extension, including the dot, \n is 255 bytes for the design of this program). \n Otherwise, the default output file are named as output.txt.\n");
	printf("\n");
	//FILE *fileout = fopen ( "output.txt", "w" );
	//	fprintf(fileout, "%s\n","");
        //fclose ( fileout );
	exit(1);
	}


  else 
    {



      strcpy(input,argv[1]);
      FILE *file = fopen ( input, "r" );
      FILE *fileout = fopen ( output, "w" );
      if (fileout == NULL)
        {
            printf("Error opening on output file!\n");
	  exit(1);
	}
      if ( file != NULL )
        {
            char buff[1000];
            //char temp[2];
            //	  char b3[15];
            char line [ 128 ]; /* or other suitable maximum line size */
            while ( fgets ( line, sizeof line, file ) != NULL ) /* read a line */
            {
                int ps=(int)strlen(line);
                char buf[1000] = ""; // max size of number in digits - 1
                char n[10] = ""; // max size of individual number - 1
                for (int i=0; i<ps; i++)
                {
                    if(isdigit(line[i]))
                    {
		      //printf("%c\n",line[i]);
                        sprintf(n, "%c", line[i]);
                        strcat(buf, n);
                        
                        strcpy(buff,buf);
                    }
                }
		
                int k=(int)strlen(buff);
                char num[16];
		if (k>10)
		{
		  printf("Your actual input, after remove all the characters that are not numbers:%s\n",buff);
		  printf("Mind that you might need to press the enter key for each line; note that if you copy the input from the pdf(latex) file, then all the input will lake the '\\zero'  in the end of the each line, in other words, all lines will be merge to one line.\n");
		    int z=0;
		    while((k/10)>1){
		    
                    sprintf(num,"(%c%c%c) %c%c%c-%c%c%c%c",buff[z],buff[z+1],buff[z+2],buff[z+3],buff[z+4],buff[z+5],buff[z+6],buff[z+7],buff[z+8],buff[z+9]);
                    fprintf(fileout, "%s\n",num);
                    // fputs ( line, stdout ); /* write the line */
		    k-=10;
		    z+=10;
		    }
		}

                if (k==10)
                {
                    sprintf(num,"(%c%c%c) %c%c%c-%c%c%c%c",buff[0],buff[1],buff[2],buff[3],buff[4],buff[5],buff[6],buff[7],buff[8],buff[9]);
                    fprintf(fileout, "%s\n",num);
                    // fputs ( line, stdout ); /* write the line */
                }
                // printf("%s\n",num);
            }//close while
        
            fclose ( file );
            fclose ( fileout );
        }//close if
    else
        {
            perror (input ); /* why didn't the file open? */
        }
    }//close else
    return 0;
    
}

