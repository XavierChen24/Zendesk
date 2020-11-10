# Zendesk
#### Project title
ZenDesk- TicTacToe Game

####Project Description
This is a text based 2-player tictactoe game. Players will take turn placing an X or O on a 3x3 board

#### To Run Project:
1.Download Zendesk.jar in out/artifacts/Zendesk.jar/Zendesk.jar<br />
2.Save to desktop<br />
3.Go to Start, search and run CMD. <br />
4.Type the following: "`cd desktop`" + Enter<br />
5.Type the following: "`Java -jdk Zendesk.jar`" + Enter<br />
6.Play.<br />

####Game Rules
1.Player 1's marker is X, Player 2's marker is O<br />
2.Player 1 or 2 determine the size of the board they are playing on<br />
3.The two player take turns placing their marker on the board, starting with Player 1<br />
4.The players can place their marker on any vacant spot<br />
5.The objective of the game is for a player to get three of their markers in a row. (horizontally, vertically or diagonally)<br />

####Algorithm to search for win condition:
The player board is n dimensions. Instead of checking the entire board, the board's last played choice will copy a 5x5 square around it and  will be copied into a 5x5 board and then checked in the following pattern.<br />

( 9)(--)(10)(--)(11)<br />
(--)( 1)( 2)( 3)(--)<br />
(16)( 8)(--)( 4)(12)<br />
(--)( 7)( 6)( 5)(--)<br />
(15)(--)(14)(--)(13)<br />

it will check the following:<br />
1,5<br />
1,9<br />
5,13<br />

3,7<br />
3,11<br />
7,15<br />

2,6<br />
2,10<br />
6,14<br />

4,8<br />
4,12<br />
8,16<br />

