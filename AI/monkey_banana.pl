% Initial state
% state(MonkeyPosition, BoxPosition, OnBox, HasBanana)

initial(state(door, window, no, no)).

% Goal state
goal(state(_, _, _, yes)).

% ---------------- MOVES ----------------

% Monkey walks
move(state(door, B, no, H),
     state(window, B, no, H)).

move(state(window, B, no, H),
     state(door, B, no, H)).

move(state(window, B, no, H),
     state(middle, B, no, H)).

move(state(middle, B, no, H),
     state(window, B, no, H)).

% Push box
move(state(window, window, no, H),
     state(middle, middle, no, H)).

move(state(middle, middle, no, H),
     state(window, window, no, H)).

% Climb box
move(state(middle, middle, no, H),
     state(middle, middle, yes, H)).

% Get banana
move(state(middle, middle, yes, no),
     state(middle, middle, yes, yes)).

% ---------------- SOLVE ----------------

% Goal reached
solve(State, _, []) :-
    goal(State).

% Search
solve(State, Visited, [Next|Path]) :-
    move(State, Next),
    \+ member(Next, Visited),
    solve(Next, [Next|Visited], Path).