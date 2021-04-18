# Jetbrains Academy - Tic Tac Toe

My solutions for the Jetbrains Academy Problem Tic Tac Toe

https://hyperskill.org/projects/123

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are five stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/123/stages/654/implement)

Just some basic output.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain

    X O X
    X O X
    X O X

## Stage 2/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/123/stages/655/implement)

We can read input and print the board.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain
    
    Enter cells: XOXOOOXXO
    ---------
    | X O X |
    | O O O |
    | X X O |
    ---------

## Stage 3/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/123/stages/656/implement)

We read input, print the board and evaluate the situation 
(do we have a winner, is the game still pending or do we have 
an impossible game situation?)

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain

    Enter cells:XXXOOOOOO
    ---------
    | X X X |
    | O O O |
    | O O O |
    ---------
    Impossible

    Enter cells:XXXOO__O_
    ---------
    | X X X |
    | O O _ |
    | _ O _ |
    ---------
    X wins

## Stage 4/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/123/stages/657/implement)

Now we make the game interactive.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain
    
    Enter cells:X______O_
    ---------
    | X _ _ |
    | _ _ _ |
    | _ O _ |
    ---------
    Enter the coordinates:
    2 2
    ---------
    | X _ _ |
    | _ X _ |
    | _ O _ |
    ---------
    Game not finished

## Stage 5/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/123/stages/658/implement)

Now we have a complete game of tic tac toe :-)

First entry (and all following odd entries) is X, second entry (and all even entries) is O

just execute this:

    gradle -PmainClass=stage5.MainKt run --console=plain
    
    ---------
    | _ _ _ |
    | _ _ _ |
    | _ _ _ |
    ---------
    Enter the coordinates:
    2 2
    ---------
    | _ _ _ |
    | _ X _ |
    | _ _ _ |
    ---------
    Game not finished
    Enter the coordinates:
    1 1
    ---------
    | O _ _ |
    | _ X _ |
    | _ _ _ |
    ---------
    Game not finished
    ...