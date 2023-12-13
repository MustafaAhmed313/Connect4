# Project Tasks

- [ ] Multiplayer [Accepted] `Mustafa Ahmed , Yousef Amir`
  - [ ] player 1 or 2 have turns automaticaly by a flag
  - [ ] 2 inputs for the two players
  - [ ] 2 scores for 2 players
  - [ ] 2 stored data for 2 players

- [ ] BugFree [Accepted] `Mustafa Ahmed , Ezzeldeen`
  - [ ] Testing
	- [ ] mouse coordinate out of range 
	- [ ] click at a full column position
	- [ ] sounds are off when it takes
	- [ ] senchronized actions and listeners at the same time
	- [ ] unique usernames
	- [ ] freezing after win or lose
	- [ ] dynamic open/close frames
	- [ ] files errors (try,catch,finally)

- [ ] Instructions [Accepted] `ALL`
    - [ ] win-lose
    - [ ] player turn
    - [ ] save the state in the game engine
    - [ ] multiplayer turns
    - [ ] single player turns
    - [ ] AI player turns
    - [ ] storage file for the users and their scores
    - [ ] detect stop point of a tuple in vertical coordinates
    - [ ] detect coordintes for mouse clicking
    - [ ] identify the range of the stop zone for the tuple

- [ ] Level Up [Accepted] `Mustafa Ahmed , Ahmed Ezzeldeen`
    - [ ] Level Easy play with random logic
    - [ ] Level Medium play with detect the nearest column for the last tuple
    - [ ] Level Hard Play with Ai (MinMax Algorithm)

- [ ] Pause [Accepted] `Elkhouly`
    - [ ] pause logic when to stop the animator for not to display the scene at a moment (Freezing)

- [X] Menu [Accepted] `ElKhouly`
    - [X] Single Player Button
    - [X] MultiPlayer Button
    - [ ] High Scores Button
    - [ ] Settings Button
    - [X] Exit Button
    - [ ] Game Background and Sound

- [X] Win-Lose [Accepted] `Yousef Amir`
    - [X] game engine logic 4 consecutive tuples
	   - [X] win horizontal
	   - [X] win vertical
	   - [X] win diagonal

- [ ] Score [Accepted] `Khafagy`
    - [ ] Store the time of the finished game for the user

- [ ] Randomness [Accepted] `Khafagy>
    - [ ] Level Easy Logic random index for the columns if their available (< 6 tuples)

- [ ] AI [Accepted] `Mustafa Ahmed`
	- [ ] Level Hard Logic MinMax Algorithm (Backtracking)

- [X] Username [Accepted] `Elkhouly`
	- [X] input for single player mode
	- [X] input for Multiplayer mode
	- [X] input for AI mode

- [ ] Collision [Accepted] `Ahmed Ezzeldeen`
	- [ ] tuple lied down from above and rest in some empty shape which is above other tuple or is the first one

- [ ] Lives [Denied]

- [ ] Graphics [Accepted] `Ahmed Ezzeleen , Elkhouly`
	- [ ] Normal tuple style (red , yellow)
	- [ ] Dragon tuple style (white black , red black)
	- [ ] The Board of tuples (blue)
	- [ ] Background for the normal scene
	- [ ] Background for the dragon scene
	- [ ] Light player switch turns
	- [ ] pause button

- [ ] 3D [Denied]

- [ ] GUI [Accepted] `Ahmed Ezzeldeen , Elkhouly`
	- [X] Main Frame
	- [X] Input Frame
	- [ ] Themes Frame
	- [ ] Settings Frame
	- [ ] Hight Scores Frame
	- [ ] Game Frame

- [ ] Clean Code [Accepted] `ALL`
	- [ ] Camel Case Variables [ex: thisVariable]
	- [ ] no nested classes
	- [ ] solid principles
	- [ ] meaningful usage of the classes and when to use
	- [ ] abstraction (As you can!)

- [ ] OOCode [Accepted] `ALL`
	- [ ] game engine class
	- [ ] gleventlistener class
	- [ ] tuple class
	- [ ] AI class
	- [ ] settings class
	- [ ] Game Views Controller

- [ ] Smooth Controls [Accepted] `Ahmed Ezzeldeen , Yousef Amir`
	- [X] mouse controls
	- [ ] keypad controls
	
- [ ] High Scores [Accepted] `Khafagy`
	- [ ] sort the user up to the shortest time they scored for their games
	- [ ] update the score of the user if he break the score by time shorter than the last score 

- [ ] Sound [Accepted] `Elkhouly`
	- [ ] turn on/off background sound
	- [X] sound for the main frame menu
	- [ ] sound for the normal scene
	- [ ] sound for the dragon scene
	- [ ] ratio input controls the sound volume

- [ ] Animation [Accepted] `Mustafa Ahmed , Ezzeldeen , Yousef Amir`
	- [X] tuple lied down with fixed previos state for the previous tuples
	
- [ ] Timer [Accepted] `Elkhouly>
	- [ ] time you take to win or lose in the game as a user