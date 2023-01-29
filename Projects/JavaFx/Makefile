JAVAC=javac --source-path src/ -d .class/
JAVA=java -cp .class/
MODULES=--module-path lib/ --add-modules javafx.controls,javafx.fxml
SRC=src/Main.java src/controllers/LoginController.java src/utilities/Utility.java src/controllers/GameController.java

all:
	$(JAVAC) $(MODULES) $(SRC)

run:
	$(JAVA) $(MODULES) src/Main.java

clean:
	rm -rf .class/*