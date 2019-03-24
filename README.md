# About the game

The game is played with enemy tanks located somewhere within a 10 by 10 grid of cells. Each turn you get to fire your gun, and then the enemy fires their guns (one per tank). They start off with N tanks(set by command line argument). Each tank occupies four connected cells forming a Tetromino (any randomly constructed one; different tanks may be different patterns). Once the enemy tanks are placed, they do not move. The frontend is shown using json objects. The UX is not implemented yet.

# Game play requirements

When playing the game, accept 0 or 1 command-line arguments to main(). If no arguments are provided, default tanks is set to N=5 tanks, otherwise if the first argument is an integer, it is used as the number of tanks. Second argument is --cheat. It will disclose the game model with the tanks contained and hence you can shot by looking at the actual position of the tanks.

To run the game, you need to go into the directory which contains the source folder of the game and run the game using the following command on the terminal: java ca.cmpt213.ui.FortressDefence <Optional 1st argument> <Optional 2nd argument>

# Contributing to the application
 
You can post suggestions about the preferred UX interface by creating an issue on the repository. You can also demonstrate your ideas through your work on the application by creating pull requests.
