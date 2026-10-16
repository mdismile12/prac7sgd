%{
#include <stdio.h>
int vowels = 0;
int consonants = 0;
%}

%option noyywrap

%%
[aeiouAEIOU] { vowels++; }
[a-zA-Z]     { consonants++; }
\n           { return 0; } /* Stop lexing and return from yylex when Enter/newline is pressed */
.            { /* Ignore spaces, numbers, punctuation, etc. */ }
%%

int main() {
    printf("Enter a string: ");
    yylex();
    printf("Vowels: %d\n", vowels);
    printf("Consonants: %d\n", consonants);
    return 0;
}
