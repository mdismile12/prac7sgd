%{
#include<stdio.h>
#include<string.h>
char word [] = "world";
int count = 0;
%}
%%
[a-zA-Z]+ { if(strcmp(yytext, word)==0) count++; }
. ;
%%
int yywrap()
{
return 1;
}
int main()
{
extern FILE *yyin, *yyout;
yyin=fopen("word.txt", "r");
yylex();
printf("Total Occurence of word:- World is: %d", count);
}