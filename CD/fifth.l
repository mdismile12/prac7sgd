%{
#include <stdio.h>
int flag = 0;
%}
WS [ \t]+
%%
"if"|"else"|"while"|"and"|"then"|"but"|"neverthless" { flag=1; }
. ;
\n { return 0; }
%%
int yywrap()
{
    return 1;
}

int main(void)
{
    printf("Enter Sentence\n");
    yylex();
    if(flag==0)
    {
        printf("Simple Sentence\n");
    }
    else
    {
        printf("Compound Sentence\n");
    }
    return 0;
}