% Initial state
initial(state(0,0)).

% Goal state: 2 litres in 4L jug
goal(state(2,_)).

% Fill 4L jug
move(state(A,B), state(4,B)) :-
    A < 4.

% Fill 3L jug
move(state(A,B), state(A,3)) :-
    B < 3.

% Empty 4L jug
move(state(A,B), state(0,B)) :-
    A > 0.

% Empty 3L jug
move(state(A,B), state(A,0)) :-
    B > 0.

% Pour 4L jug into 3L jug
move(state(A,B), state(A1,B1)) :-
    A > 0, B < 3,
    T is min(A, 3-B),
    A1 is A-T,
    B1 is B+T.

% Pour 3L jug into 4L jug
move(state(A,B), state(A1,B1)) :-
    B > 0, A < 4,
    T is min(B, 4-A),
    A1 is A+T,
    B1 is B-T.

% Stop when goal is reached
solve(State, _, []) :-
    goal(State).

% Search for a solution
solve(State, Visited, [Next|Path]) :-
    move(State, Next),
    \+ member(Next, Visited),
    solve(Next, [Next|Visited], Path).