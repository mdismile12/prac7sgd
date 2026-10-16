male(james1).
male(charles1).
male(charles2).
male(james2).
male(george1).

female(catherine).
female(elizabeth).
female(sophia).

parent(charles1, james1).
parent(elizabeth, james1).
parent(charles2, charles1).
parent(catherine, charles1).
parent(james2, charles1).

parent(sophia, elizabeth).
parent(george1, sophia).

mother(X, M) :- parent(X, M), female(M).
father(X, F) :- parent(X, F), male(F).
sibling(X, Y) :- parent(X, Z), parent(Y, Z).
grandparent(X, G) :- parent(X, P), parent(P, G).
cousin(X, Y) :- parent(X, P1), parent(Y, P2), sibling(P1, P2), P1 \== P2.