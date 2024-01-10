# Chess Group Project
Chess Group Project for CMPT 276 (Introduction to Software Engineering), Summer 2023.  
While the submitted final result is private and only accessible by the group members and the teacher, this repository presents the work I was responsble of for my group.  
My primary responsibility was to manage the setup of the board, as well as presentation of the pieces. Additionally, while movement restrictions specific to each piece 
were later organized and implemented by the other members of my group, I had the sole responsibility for the intial prototype, which implemented general movement of the 
pieces, which was essentially their ability to "move" at all.  

The project in this respository is the prototype I mentioned above.

<u>Instructions:</u>

To compile, please run the makefile by typing "make" into the terminal.

This command will give you a command to run the created project.

To move pieces, please click and drag to the desired location.



As this is a very early stage prototype, there are numerous issues that were fixed later on in production, but will be seen in this repository. Some of these things include: 
- Pieces not bound by any movement rules (ex. bishop can 5 spaces across the board).
- Black pieces will move even if you do not move a piece (releasing your mouse triggers the oppponent's move).
- The player can move pieces of either color, but only if the computer has not moved that piece yet.
- The program is lacking a clean way to exit the program, to exit, please end the program in task manager or a similar alternative.
