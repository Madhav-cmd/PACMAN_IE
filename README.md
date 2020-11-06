# PACMAN_IE
Created Using Eclipse Version: Oxygen.3a Release (4.7.3a)
The program is written in Java. 

The description of the program is as follows:

The application is a simulation of Pacman moving on in a grid, of dimensions 5 units x 5 units.
There are no other obstructions on the grid.
Pacman is free to roam around the surface of the grid, but must be prevented from moving off the grid. Any movement that would result in Pacman moving off the grid must be prevented, however further valid movement commands must still be allowed.

The commands include: 

PLACE X,Y,F

MOVE

LEFT

RIGHT

REPORT

PLACE will put the Pacman on the grid in positon X,Y and facing NORTH,SOUTH, EAST or WEST.
The first valid command to Pacman is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.

MOVE will move Pacman one unit forward in the direction it is currently facing.

LEFT and RIGHT will rotate Pacman 90 degrees in the specified direction without changing the position of Pacman.

REPORT will announce the X,Y and F of Pacman. This can be in any form, but standard output is sufficient.

Pacman that is not on the grid can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.

Constraints:

Pacman must not move off the grid during movement. This also includes the initial placement of Pacman.
Any move that would cause Pacman to fall must be ignored.
