#include <stdio.h>
#include <string.h> // Used for strlen() function
#define TRUE 1
#define FALSE 0
#define size 20
int top, status;

/*PUSH FUNCTION*/
void push (char stack[], char item)
{   if (top == (size-1))
    status = 0;
else
{   status = 1;
    ++top;
    stack [top] = item;
}
}

/*POP FUNCTION*/
char pop (char stack[])
{
    int ret;
    if (top == -1)
    {   ret = 0;
        status = 0;
    }
    else
    {   status = 1;
        ret = stack [top];
        --top;
    }
    return ret;
}

/*FUNCTION TO DISPLAY STACK*/
void display (char stack[])
{   int i;
    printf ("\nThe Stack is: ");
    if (top == -1)
        printf ("empty");
    else
    {   for (i=top; i>=0; --i)
        printf ("\n--------\n|%c   |\n--------",stack[i]);
    }
    printf ("\n");
}
void make_empty(char stack[], int coun)
{
    int o;
    for (o=0; o<coun;o++)
    {
        pop(stack);
    }
}

int main()
{
  int top = -1;
  int item;
  int c, t;
    int coun,coun2;
  char n[20],p[20];
  char k[20];
  char u[20];
  char stack[20]; // Limits characters
  int j,m,o;
  int intTest;
  int l=strlen(stack);
  int c1, c2, c3, c4;
  c1=0;
  c2=0;
  c3=0;
  c4=0;
    intTest=TRUE;
    char a;
    int i;
    //printf("Enter your input that contains parenthesis or Q to quit: \n");
  
    
  while (intTest==TRUE){
      printf("Enter your input that contains parenthesis or Q to quit: \n");
      //c=getchar();
      //if (c=='Q'){return 0;}
      scanf("%s", n);
      i = strlen(n);      // to merge the spaces, count the length of the input until first space
      do
      {
          scanf("%c", &a);
          n[i++] = a;       // read character by character, after the first char of the first space
      } while (a != '\n');     // waiting till the user hits Enter key
      n[i - 1] = 0; //close
      
      if ((l=strlen(n))>20){printf("The input is not balanced.\n");continue;}
      else{
      c1=c2=c3=c4=coun=0;
    
      for (j=0;j<strlen(n);j++)
      {
          if (n[j]=='Q'){return 0;}//? Q cannot be in the input?
          else
          {
              if (n[j]=='('){item=n[j];push(stack,item);coun++;++c1;}
              if (n[j]==')'){item=n[j];push(stack,item);coun++;++c2;}
              if (n[j]=='{'){item=n[j];push(stack,item);coun++;++c3;}
              if (n[j]=='}'){item=n[j];push(stack,item);coun++;++c4;}
          }
      }
          printf("%d\n",coun);
          if (coun==0){printf("There is no parenthesis or braces in your input.\n");continue;}//a quick way to avoid to run the pop function
          else if (coun==1){printf("The input is not balanced.\n");continue;}//a quick way to avoid to run the pop function
          else if (c1!=c2||c3!=c4){printf("The input is not balanced.\n");continue;}//a quick way to avoid to run the pop function
          else if (coun>1){
          u[0]='\0';
          for (o=0; o<coun;o++)
          {
              k[o]=pop(stack);
              
              u[o+1]=k[o];
              if (u[o]==')'){
                  if (u[o+1]=='{'){printf("The input is not balanced.\n");continue;}}
              else if (u[o]=='}'){
                  if (u[o+1]=='('){printf("The input is not balanced.\n");continue;}}

          }
          
          if (k[0]=='('||k[0]=='{'){printf("The input is not balanced.\n");continue;}//a quick way to avoid to run the pop function
          else if (k[coun-1]==')'||k[coun-1]=='}'){printf("The input is not balanced.\n");continue;}//a quick way to avoid to run the pop function
          }
          
      }
      make_empty(p,coun);
  };
  
    return 0;
}
