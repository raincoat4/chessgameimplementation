#compiler
JAVAC = javac

#source files
SRCS = chessgame/ChessGame.java chessgame/ChessPiece.java

#image files
IMAGES = chess.png

#classes directory
CLASSES_DIR = classes

#main class
MAIN_CLASS = chessgame.ChessGame

#default target
all: $(CLASSES_DIR) $(MAIN_CLASS)

#rule to create classes directory
$(CLASSES_DIR):
	mkdir -p $(CLASSES_DIR)

#rule to compile Java source files
$(CLASSES_DIR)/%.class: %.java
	$(JAVAC) -d $(CLASSES_DIR) $<

#copy image files to classes directory
$(CLASSES_DIR)/%.png: %.png
	cp $< $(CLASSES_DIR)

#rule to build the main class
$(MAIN_CLASS): $(addprefix $(CLASSES_DIR)/, $(SRCS:.java=.class)) $(addprefix $(CLASSES_DIR)/, $(IMAGES))
	@echo "Build complete. Run with: java -cp $(CLASSES_DIR) $(MAIN_CLASS)"

#clean target to remove compiled classes
clean:
	rm -rf $(CLASSES_DIR)

#phony target to force the rules to execute, even if there are files named 'all' or 'clean'
.PHONY: all clean
