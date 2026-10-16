diagnose(flu) :-
    write('Do you have fever? (yes/no): '), read(Fever),
    write('Do you have cough? (yes/no): '), read(Cough),
    write('Do you have body pain? (yes/no): '), read(BodyPain),
    Fever = yes,
    Cough = yes,
    BodyPain = yes.

diagnose(common_cold) :-
    write('Do you have cough? (yes/no): '), read(Cough),
    write('Do you have runny nose? (yes/no): '), read(RunnyNose),
    write('Do you have sore throat? (yes/no): '), read(SoreThroat),
    Cough = yes,
    RunnyNose = yes,
    SoreThroat = yes.

diagnose(dengue) :-
    write('Do you have fever? (yes/no): '), read(Fever),
    write('Do you have headache? (yes/no): '), read(Headache),
    write('Do you have body pain? (yes/no): '), read(BodyPain),
    write('Do you have rash? (yes/no): '), read(Rash),
    Fever = yes,
    Headache = yes,
    BodyPain = yes,
    Rash = yes.

start :-
    diagnose(Disease),
    write('Possible diagnosis: '),
    write(Disease),
    nl.