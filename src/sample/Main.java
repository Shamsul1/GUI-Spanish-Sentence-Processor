package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static final String excel_path = "C:\\Users\\Samsul Karim\\Desktop\\All Noun Gendered.xlsx";
    private TableView table = new TableView();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com")
            );

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Spanish Sentence Processor");
        primaryStage.setScene(new Scene(root, 600, 675));

        //Border Pane

        BorderPane borderPane = new BorderPane();

        // Table
        TableColumn imperfectCol = new TableColumn("Imperfect");
        TableColumn preteritCol = new TableColumn("Preterit");
        TableColumn presentCol = new TableColumn("Present");
        TableColumn conditionalCol = new TableColumn("Conditional");
        TableColumn futureCol = new TableColumn("Future");
        table.getColumns().addAll(imperfectCol, preteritCol, presentCol,conditionalCol,futureCol);
        table.setPrefSize(400,100);
        GridPane.setConstraints(table,0,0);


        GridPane gridPane = getTopGridPane();
        GridPane bottonGrindPane = getBottomGridPane();

        GridPane centerGridPane = getCenterGridPane();


        borderPane.setTop(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        borderPane.setCenter(centerGridPane);
        centerGridPane.setAlignment(Pos.CENTER);

        borderPane.setBottom(bottonGrindPane);
        bottonGrindPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(borderPane,700,600);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane getCenterGridPane() throws IOException {
        GridPane centerGridPane = new GridPane();


        Text sentenceCountText = new Text();
        sentenceCountText.setText("Pudo - Sentence(s): "+5);
        GridPane.setHalignment(sentenceCountText,HPos.CENTER);
        sentenceCountText.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(sentenceCountText,0,0);

        Text sentenceText = new Text();
        sentenceText.setText("This is a text sample");
        sentenceText.setFont(Font.font ("Verdana", 20));
        sentenceText.setFill(Color.BLACK);
        sentenceText.setLineSpacing(5);

        sentenceText.setText("Cuando pasaron el edificio, Kaneka pudo ver a su objetivo.\nWhen they passed the building, Kaneka could see his target");
        GridPane.setConstraints(sentenceText,0,1);
        sentenceText.prefHeight(1000);

        Button removeSentenceButton = new Button();
        removeSentenceButton.setText("Remove");
        GridPane.setConstraints(removeSentenceButton,0,2);
        GridPane.setHalignment(removeSentenceButton,HPos.CENTER);
        removeSentenceButton.setDisable(true);


        centerGridPane.getChildren().add(sentenceCountText);
        centerGridPane.getChildren().add(sentenceText);
        centerGridPane.getChildren().add(removeSentenceButton);

        //Setting size for the pane
        centerGridPane.setMinSize(400, 200);

        //Setting the padding
        centerGridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        centerGridPane.setVgap(20);
        centerGridPane.setHgap(5);



        //creating a Sheet object to retrieve object
//        File file = new File(excel_path);   //creating a new file instance
//        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sheet = wb.getSheetAt(0);
//
//
//        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
//        int count =0;
//        while (itr.hasNext()) {
//            Row row = itr.next();
//            System.out.println("Hello");
//        }



        return centerGridPane;
    }

    private GridPane getTopGridPane() {
        // Top PaneButton
        Button button = new Button();
        button.setText("Next Word");
        GridPane.setConstraints(button,0,1);

        // Grind
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.getChildren().add(table);
        gridPane.getChildren().add(button);
        GridPane.setHalignment(button, HPos.CENTER);

        return gridPane;
    }

    private GridPane getBottomGridPane() {
        // Bottom Pane Buttons
        Button prevSentenceButton = new Button();
        prevSentenceButton.setText("Previous Sentence");
        GridPane.setConstraints(prevSentenceButton,0,0);

        Button addSentenceButton = new Button();
        addSentenceButton.setText("Add Sentence");
        GridPane.setConstraints(addSentenceButton,1,0);


        Button nextSentenceButton = new Button();
        nextSentenceButton.setText("Next Sentence");
        GridPane.setConstraints(nextSentenceButton,2,0);

        GridPane bottonGrindPane = new GridPane();
        bottonGrindPane.getChildren().add(prevSentenceButton);
        bottonGrindPane.getChildren().add(addSentenceButton);
        bottonGrindPane.getChildren().add(nextSentenceButton);

        //Setting size for the pane
        bottonGrindPane.setMinSize(400, 200);

        //Setting the padding
        bottonGrindPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        bottonGrindPane.setVgap(5);
        bottonGrindPane.setHgap(5);


        return bottonGrindPane;
    }


    public static void main(String[] args) {
        launch(args);
    }



    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }

}
