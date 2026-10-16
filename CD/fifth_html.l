%{
#include<stdio.h>
%}
%%
\<[^>]*\> fprintf(yyout,"%s\n",yytext);
.|\n;
%%
int yywrap()
{return 1;}
int main()
{
yyin=fopen("cd.html","r");
yyout=fopen("prac5.txt","w");
yylex();
return 0;
}