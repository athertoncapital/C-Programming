/**
*William H Chuang Feb 26 2016
*
*/
1. This game will stop as you hit the "esc".

2. You can control the red brick by using LEFT and RIGHT keys.

3. The “Level” can be reseted when you hit the “Enter” key.

4. As one of the players get 3 points, the players will go into a different level:
(i) if AI wins, then the number of level will be subtracted by one.
(ii) likewise, if human player wins, the player will be sent to a new level.

5. No matter the player is go to positive increasing level number direction or not, the width of the RedBrick will shrinking. It counts by how many times the number of level changes, and it reflects the experience of the player. In other words, the longer the player stay in the game, the shorter of the Paddle (RedBrick) will be.

6. The Game Over overlay will show once the user reach level -7. Then, there are three options: 
(i) one is keep playing as a ghost, 

(ii)or hit enter to reset the level (but the size of the brick will be reserve, since the user is more experienced than before so that could feel more challenge and more funs). But, if the user lose in the level -7, the window will be closed automatically to end the ghost mode.

(iii) The final option is to hit the escape directly, then one can restart the game with a releasing size of of the red brick!

7. There are totally 7 levels in this game. In positive level value direction, each new level will give one more pong ball, and if the user lose at the nth level, that nth ball will seize to move right away until the user fight back from the (n-1)th level.