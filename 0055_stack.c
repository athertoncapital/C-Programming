#include <stdio.h>
#include <string.h>
#define TRUE 1
#define FALSE 0
#define size 20
int top, status;

int counter=0;
int top = -1;
int item;
int coun,coun2;
char n[20];
char stack[20]; // Limits characters
int j,o,l;
int intTest;

/*PUSH FUNC.*/
void push (char stack[], char item)
{   if (top == (size-1))
    status = 0;
  else
    {   status = 1;
      ++top;
      stack [top] = item;
    }
}

/*POP FUNC.*/
char pop (char stack[])
{
  int ret;
  if (top == -1)
    {   ret = '\0';
      status = 0;
    }
  else
    {   status = 1;
      ret = stack [top];
      --top;
    }
  return ret;
}

void make_empty(char stack[], int coun)
{
    int o;
    for (o=0; o<coun;o++)
    {
        stack[o]='\0';
    }

}

void printarray(char s[],int n)
{
    int g;
    for(g=0; g<n; g++)
    printf("%c\n",s[g]);
}

int main()
{  int c1, c2, c3, c4,c5,c6,c7,c8;
  c1=0;
  c2=0;
  c3=0;
  c4=0;
  c5=0;
  c6=0;
  c7=0;
  c8=0;
  intTest=TRUE;
  int i;
  int test;
    int c,C;
    int q,Q,S;
    char K[10];
    char lambda[1],Lambda[1];
    
  while (intTest==TRUE){
    test=TRUE;
      c1=c2=c3=c4=c5=c6=c7=c8=coun=i=0;
    printf("Enter your input that contains parenthesis or Q to quit: \n");
      make_empty(n,20);
      make_empty(stack,20);
      make_empty(K,10);
      
      while((c = getchar())!='\n')
            {
                if (c=='('){n[i]=c;i++;}
                else if (c==')'){n[i]=c;i++;}
                else if (c=='{'){n[i]=c;i++;}
                else if (c=='}'){n[i]=c;i++;}
                else if (c=='['){n[i]=c;i++;}
                else if (c==']'){n[i]=c;i++;}
                else if (c=='<'){n[i]=c;i++;}
                else if (c=='>'){n[i]=c;i++;}
                else if (i==0&&c=='Q'){n[i]=c;i++;}
                else {n[i]='\0';}

            }
      
      //in order to remove the Q for the cases if Qis the first char, we need to purify the input, so push all elements in n[20] to stack[20]
      n[i]='\0';
      if (i==1&&n[0]=='Q'){return 0;}
      else if (i>20){printf("The input is not balanced.");make_empty(n,20);i=0;}
      else{
          c1=c2=c3=c4=c5=c6=c7=c8=coun=0;
          for (j=0;j<i;j++)
          {
              if (n[j]=='('){item=n[j];push(stack,item);coun++;++c1;}
              if (n[j]==')'){item=n[j];push(stack,item);coun++;++c2;}
              if (n[j]=='{'){item=n[j];push(stack,item);coun++;++c3;}
              if (n[j]=='}'){item=n[j];push(stack,item);coun++;++c4;}
              if (n[j]=='['){item=n[j];push(stack,item);coun++;++c5;}
              if (n[j]==']'){item=n[j];push(stack,item);coun++;++c6;}
              if (n[j]=='<'){item=n[j];push(stack,item);coun++;++c7;}
              if (n[j]=='>'){item=n[j];push(stack,item);coun++;++c8;}
              stack[j+1]='\0';
          }
          if (coun==0){printf("There is no parenthesis or braces in your input.\n");make_empty(stack,20);make_empty(n,20);c1=c2=c3=c4=c5=c6=c7=c8=coun=0;i=0;}//a quick way to avoid to run the pop function
          else if (coun==1||c1!=c2||c3!=c4||c5!=c6||c7!=c8){printf("The input is not balanced.\n");make_empty(stack,20);make_empty(n,20);c1=0;c2=0;c3=0;c4=0;c5=0;c6=0;c7=0;c8=0;coun=0;i=0;}//during the pop phase, a quick way to reach the result by memorizing the numbers of the each kind of closing and opening braces, brakets, etc. to see whether or not they could be a pair
          else {

              if (stack[0]==')'||stack[0]=='}'||stack[0]==']'||stack[0]=='>'||stack[coun-1]=='('||stack[coun-1]=='{'||stack[coun-1]=='['||stack[coun-1]=='<'){printf("The input is not balanced.\n");make_empty(stack,20);make_empty(n,20);i=0;c1=c2=c3=c4=c5=c6=c7=c8=coun=0;i=0;}//a quick way to make sure the order to pop out is start from closing braces
              else {


                  test=TRUE;
                  while (test==TRUE&&coun>0)
                  {
                      
                      l=strlen(stack);
                      counter=0;


                      while (stack[coun-1]!='{'&&stack[coun-1]!='['&&stack[coun-1]!='<'&&stack[coun-1]!='(')
                      {
                          if (stack[coun-1]=='{'&&stack[coun-1]=='['&&stack[coun-1]=='<'&&stack[coun-1]=='('){break;}
                          else if (stack[coun-1]=='}'){push(K,'{');pop(stack);}
                          else if (stack[coun-1]==']'){push(K,'[');pop(stack);}
                          else if (stack[coun-1]==')'){push(K,'(');pop(stack);}
                          else if (stack[coun-1]=='>'){push(K,'<');pop(stack);}

                          counter++;
                          coun--;

  
                      }
                      
                      
                      for (C=0;C<counter;C++)
                      {
                          lambda[0]=pop(K);
                          Lambda[0]=pop(stack);

                          
                          if (lambda[0]==Lambda[0]){
                              
                              printf("%d",counter);
                              coun--;
                              if (coun==0&&C==counter-1){printf("The input is balanced.\n");}
                              else continue;}
                          else{printf("The input is not balanced.\n");make_empty(stack,20);make_empty(n,20);c1=0;c2=0;c3=0;c4=0;c5=0;c6=0;c7=0;c8=0;coun=counter=0;i=0;}
                          
                      }
                  
                      
                      
                  }
                  
                  
              }// end while (test=TRUE)

                  
                  
          //}
        

    }//end else
      }
  }
  return 0;
}//end int main()
