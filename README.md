## Achilles
# CS3733 Software Engineering

**Folders Included:**

*src* - 

	Boundary\Both 
		Includes boundary classes used in both Kabasuji and the LevelBuilder.
	Boundary\Builder
		Includes boundary classes used only in the LevelBuilder.
	Boundary\Player
		Includes boundary classes used only in Kabasuji.
	BuiltLevels\LightningLevels
		Contains the serialized text files for all lightning levels.
	BuiltLevels\PuzzleLevels
		Contains the serialized text files for all puzzle levels.
	BuiltLevels\ReleaseLevels
		Contains the serialized text files for all release levels.
	Controller
		Includes all controller classes used in both Kabasuji and the LevelBuilder.
	DefaultLevels\LightningLevels
		Contains the static serialized level files for all built in lightning levels.
	DefaultLevels\PuzzleLevels
		Contains the static serialized level files for all built in puzzle levels.
	DefaultLevels\ReleaseLevels
		Contains the static serialized level files for all built in release levels.	
	Game
		Includes all entity classes.
	Main
		Includes classes to run the program.

*KabasujiTest* - 
	Tests
		Includes all of the test to show the application functions properly.

*Image* - 
	Contains all graphics used within Kabasuji and the LevelBuilder.
	
**How to run**
To play the Kabasuji game navigate to the Main package in the src folder and open the KabasujiMain.java file and click run. 
This will initialize the game and load all the static levels and any built levels there might be.

To use the LevelBuilder application navigate to the Main package in the src folder and open the LevelBuilderMan.java file and click run.
This will load any built levels and allow you to create any new levels.

**Functionality**

*Playing a game* - 
	To play a level first choose whether you want to play static levels or built levels. From here is a menu and please choose to play an available level.
	After a level is chosen you will begin. To move a piece onto the board from the bullpen simply click on the desired piece and place it onto the board.
	If you are playing a puzzle level you will be able to move pieces after they are placed on the board. You win if you get at least one star.
	
*Building a level* - 
	To build a level first choose a level type that you want to build from there select pieces from the stock on the right and click in the bullpen to add them.
	To enter save any data for any level ensure that you press the corresponding "enter" or "set" button in order to correctly serialize entities. 
	If you do not enter sufficient information for a level the level will not be serialized.
	To add hints to a board, first add a piece to the bullpen and from there add it to the board, select the piece on the board and click add hint.
	The piece will be marked and visible when playing the level.
