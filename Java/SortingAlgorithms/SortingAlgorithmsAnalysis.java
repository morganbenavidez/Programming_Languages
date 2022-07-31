/**
 *
 * @author Morgan Benavidez
 */
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class SortingAlgorithmsAnalysis extends Application {
   
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Sorting Algorithms Analysis");

        // Creating a Grid Pane
        GridPane gridPane = new GridPane();
        
        // Setting size for the Pane
        gridPane.setMinSize(600, 600);
        
        // Setting the Padding
        gridPane.setPadding(new Insets(10,10,10,10));
        
        // Setting the vertical and horizontal gaps between the columns
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        // Setting the Grid allignment
        gridPane.setAlignment(Pos.TOP_CENTER);
        
        // Add a scroll bar?
        ScrollBar sl = new ScrollBar();

        // Create a scene
        Scene scene = new Scene(gridPane, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Create Array Lists
        List<Double> speedsList = new ArrayList<>();
        List<String> namesList = new ArrayList<>();
        
        // Create Line Chart
        NumberAxis xAxis = new NumberAxis(0, 10000, 1000);
        xAxis.setLabel("Number of Elements");
        NumberAxis yAxis = new NumberAxis(0, 10, 1);
        yAxis.setLabel("Time (In Milliseconds)");
                
        // Create a Line Chart
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.setTitle("Runtime Analysis");
                
        // Dimensions of Line Chart
        lineChart.setPrefHeight(450);
        lineChart.setMinHeight(450);
        lineChart.setMaxHeight(450);
                
        lineChart.setPrefWidth(450);
        lineChart.setMinWidth(450);
        lineChart.setMaxWidth(450);
                
        lineChart.setPrefSize(450, 450);
        lineChart.setMinSize(450, 450);
        lineChart.setMaxSize(450, 450);
        
        // Create First Row
        Label label1 = new Label ("Please enter number of items: ");
        TextField textField1 = new TextField ();
        textField1.setPromptText("Enter Total Items");
        
        // Create Second Row
        Label label2 = new Label ("Please enter the range of data: ");
        TextField textField2 = new TextField ();
        textField2.setPromptText("Enter Minimum Value");
        Label label3 = new Label (" to ");
        TextField textField3 = new TextField ();
        textField3.setPromptText("Enter Maximum Value");
        
        // Create Third Row
        Label label4 = new Label ("Compare: ");
        ChoiceBox choiceBox1 = new ChoiceBox(FXCollections.observableArrayList(
            "Insertion Sort", "Merge Sort", "Heap Sort", 
            "Quick Sort", "Counting Sort", "Radix Sort")
        );
        Label label5 = new Label (" to ");
        ChoiceBox choiceBox2 = new ChoiceBox(FXCollections.observableArrayList(
            "Insertion Sort", "Merge Sort", "Heap Sort", 
            "Quick Sort", "Counting Sort", "Radix Sort")
        );
        
        // Create Fourth Row
        RadioButton radioButton1 = new RadioButton("Compare All ");
        radioButton1.setOnAction(e -> {
            if(radioButton1.isSelected() == true){
                choiceBox1.setDisable(true);
                choiceBox2.setDisable(true);
            }
            if(radioButton1.isSelected() == false){
                choiceBox1.setDisable(false);
                choiceBox2.setDisable(false);
            }
            /*
            boolean isMyComboBoxEmpty1 = (choiceBox1.getValue() = null);
                if(isMyComboBoxEmpty1 == false){
                   //choiceBox1.getSelectionModel().clearSelection();
                   choiceBox1.setValue(null);
                };
            //boolean disable = !choiceBox1.isDisabled();
            choiceBox1.setDisable(disable);
            boolean disable2 = !choiceBox2.isDisabled();
            choiceBox2.setDisable(disable2);
            */
        });
        
        // Create Bottom Rows
        Label label6 = new Label ("");
        Label label7 = new Label ("");
        
        // Create Run Button
        Button button2 = new Button ("Run");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                // Creating random numbers to populate the array
                SecureRandom generator = new SecureRandom();
                
                // Pulling parameters from text fields
                int min = Integer.parseInt(textField2.getText());
                int max = Integer.parseInt(textField3.getText());
                int totalItems = Integer.parseInt(textField1.getText());
                
                // Create unsorted array of ints with values between 1 -
                int[] data = generator.ints(totalItems, min, max).toArray();
                int[] dataClone1 = data.clone();
                int[] dataClone2 = data.clone();
                int[] dataClone3 = data.clone();
                int[] dataClone4 = data.clone();
                int[] dataClone5 = data.clone();
                int[] dataClone6 = data.clone();
                
                // Creating the Series of data (lines) for each Sort
                XYChart.Series insertionSortSeries = new XYChart.Series();
                insertionSortSeries.setName("Insertion Sort ");
                XYChart.Series mergeSortSeries = new XYChart.Series();
                mergeSortSeries.setName("Merge Sort ");
                XYChart.Series heapSortSeries = new XYChart.Series();
                heapSortSeries.setName("Heap Sort ");
                XYChart.Series quickSortSeries = new XYChart.Series();
                quickSortSeries.setName("Quick Sort ");
                XYChart.Series countingSortSeries = new XYChart.Series();
                countingSortSeries.setName("Counting Sort ");
                XYChart.Series radixSortSeries = new XYChart.Series();
                radixSortSeries.setName("Radix Sort ");
                
                // Print Unsorted Array
                System.out.printf("Initial Array: %s%n%n", Arrays.toString(data));
                
                // Pull comparison choices
                String choice1 = (String) choiceBox1.getValue();
                String choice2 = (String) choiceBox2.getValue();
                
                // Insertion Sort
                if ((choice1 == "Insertion Sort") || (choice2 == "Insertion Sort") || (radioButton1.isSelected() == true)){
                    // Initializing Insertion Sort
                    InsertionSort Number1 = new InsertionSort();
                    // Timing the Insertion Sort Call
                    long InsertionSortStartTime = System.nanoTime();
                    Number1.insertionSort(dataClone1);
                    long InsertionSortEndTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String IsSorted = Arrays.toString(dataClone1);
                    // Calculating Run Time
                    double InsertionSortRunTime = InsertionSortEndTime - InsertionSortStartTime;
                    // Converting From nanoseconds to seconds
                    double InsertionSortInMilliSeconds = (double)(InsertionSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int ISLC = (int) InsertionSortInMilliSeconds;
                    // Create a Variable to Hold Insertion Sort Run Time
                    String RunTimeInsertionSortMilliSeconds = String.valueOf(InsertionSortInMilliSeconds);
                    // Print Sorted Array (Insertion Sort)
                    System.out.println("Array Sorted with Insertion Sort: " + IsSorted);
                    // Print Run Time (Insertion Sort)
                    System.out.println("Insertion Sort Run Time: " + RunTimeInsertionSortMilliSeconds + " milliseconds");
                    // Add to series data
                    insertionSortSeries.getData().add(new XYChart.Data(0,0));
                    insertionSortSeries.getData().add(new XYChart.Data(totalItems, InsertionSortInMilliSeconds));
                    lineChart.getData().add(insertionSortSeries);
                    speedsList.add(InsertionSortInMilliSeconds);
                    namesList.add("Insertion Sort");
                };
                
                // Merge Sort
                if((choice1 == "Merge Sort") || (choice2 == "Merge Sort") || (radioButton1.isSelected() == true)){
                    // Instantiating Merge Sort
                    MergeSort Number2 = new MergeSort();
                    // Timing the Merge Sort Call
                    double msstartTime = System.nanoTime();
                    Number2.mergeSort(dataClone2); // sort array
                    double msendTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String MsSorted = Arrays.toString(dataClone2);
                    // Calculating Run Time
                    double MergeSortRunTime = msendTime - msstartTime;
                    // Converting from nanoseconds to seconds
                    double MergeSortInMilliSeconds = (double)(MergeSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int MSLC = (int) MergeSortInMilliSeconds;
                    // Create a Variable to Hold Merge Sort Run Time
                    String RunTimeMergeSortMilliSeconds = String.valueOf(MergeSortInMilliSeconds);
                    // Print Sorted Array (Merge Sort)
                    System.out.println("Array Sorted with Merge Sort: " + MsSorted);
                    // Print Run Time (Merge Sort)
                    System.out.println("Merge Sort Run Time: " + RunTimeMergeSortMilliSeconds + " milliseconds");
                    // Add to series data
                    mergeSortSeries.getData().add(new XYChart.Data(0,0));
                    mergeSortSeries.getData().add(new XYChart.Data(totalItems, MergeSortInMilliSeconds));
                    lineChart.getData().add(mergeSortSeries);
                    speedsList.add(MergeSortInMilliSeconds);
                    namesList.add("Merge Sort");
                };
                
                // Heap Sort
                if ((choice1 == "Heap Sort") || (choice2 == "Heap Sort") || (radioButton1.isSelected() == true)){
                    // Initializing Heap Sort
                    HeapSort Number3 = new HeapSort();
                    // Timing the Heap Sort Call
                    long HeapSortStartTime = System.nanoTime();
                    Number3.heapSort(dataClone3);
                    long HeapSortEndTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String HsSorted = Arrays.toString(dataClone3);
                    // Calculating Run Time
                    double HeapSortRunTime = HeapSortEndTime - HeapSortStartTime;
                    // Converting From nanoseconds to seconds
                    double HeapSortInMilliSeconds = (double)(HeapSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int HSLC = (int) HeapSortInMilliSeconds;
                    // Create a Variable to Hold Heap Sort Run Time
                    String RunTimeHeapSortMilliSeconds = String.valueOf(HeapSortInMilliSeconds);
                    // Print Sorted Array (Heap Sort)
                    System.out.println("Array Sorted with Heap Sort: " + HsSorted);
                    // Print Run Time (Heap Sort)
                    System.out.println("Heap Sort Run Time: " + RunTimeHeapSortMilliSeconds + " milliseconds");
                    // Add to series data
                    heapSortSeries.getData().add(new XYChart.Data(0,0));
                    heapSortSeries.getData().add(new XYChart.Data(totalItems, HeapSortInMilliSeconds));
                    lineChart.getData().add(heapSortSeries);
                    speedsList.add(HeapSortInMilliSeconds);
                    namesList.add("Heap Sort");
                };
                
                // Quick Sort
                if ((choice1 == "Quick Sort") || (choice2 == "Quick Sort") || (radioButton1.isSelected() == true)){
                    // Initializing Quick Sort
                    QuickSort Number4 = new QuickSort();
                    // Timing the Quick Sort Call
                    long QuickSortStartTime = System.nanoTime();
                    Number4.quickSort(dataClone4, 0, dataClone4.length-1);
                    long QuickSortEndTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String QsSorted = Arrays.toString(dataClone4);
                    // Calculating Run Time
                    double QuickSortRunTime = QuickSortEndTime - QuickSortStartTime;
                    // Converting From nanoseconds to seconds
                    double QuickSortInMilliSeconds = (double)(QuickSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int QSLC = (int) QuickSortInMilliSeconds;
                    // Create a Variable to Hold Quick Sort Run Time
                    String RunTimeQuickSortMilliSeconds = String.valueOf(QuickSortInMilliSeconds);
                    // Print Sorted Array (Quick Sort)
                    System.out.println("Array Sorted with Quick Sort: " + QsSorted);
                    // Print Run Time (Heap Sort)
                    System.out.println("Quick Sort Run Time: " + RunTimeQuickSortMilliSeconds + " milliseconds");
                    // Add to series data
                    quickSortSeries.getData().add(new XYChart.Data(0,0));
                    quickSortSeries.getData().add(new XYChart.Data(totalItems, QuickSortInMilliSeconds));
                    lineChart.getData().add(quickSortSeries);
                    speedsList.add(QuickSortInMilliSeconds);
                    namesList.add("Quick Sort");
                };
                
                // Counting Sort
                if ((choice1 == "Counting Sort") || (choice2 == "Counting Sort") || (radioButton1.isSelected() == true)){
                    // Initializing Counting Sort
                    CountingSort Number5 = new CountingSort();
                    // Timing the Counting Sort Call
                    long CountingSortStartTime = System.nanoTime();
                    Number5.countingSort(dataClone5, max);
                    long CountingSortEndTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String CsSorted = Arrays.toString(dataClone5);
                    // Calculating Run Time
                    double CountingSortRunTime = CountingSortEndTime - CountingSortStartTime;
                    // Converting From nanoseconds to seconds
                    double CountingSortInMilliSeconds = (double)(CountingSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int CSLC = (int) CountingSortInMilliSeconds;
                    // Create a Variable to Hold Counting Sort Run Time
                    String RunTimeCountingSortMilliSeconds = String.valueOf(CountingSortInMilliSeconds);
                    // Print Sorted Array (Counting Sort)
                    System.out.println("Array Sorted with Counting Sort: " + CsSorted);
                    // Print Run Time (Counting Sort)
                    System.out.println("Counting Sort Run Time: " + RunTimeCountingSortMilliSeconds + " milliseconds");
                    // Add to series data
                    countingSortSeries.getData().add(new XYChart.Data(0,0));
                    countingSortSeries.getData().add(new XYChart.Data(totalItems, CountingSortInMilliSeconds));
                    lineChart.getData().add(countingSortSeries);
                    speedsList.add(CountingSortInMilliSeconds);
                    namesList.add("Counting Sort");
                };
                
                // Radix Sort
                if ((choice1 == "Radix Sort") || (choice2 == "Radix Sort") || (radioButton1.isSelected() == true)){
                    // Initializing Radix Sort
                    RadixSort Number6 = new RadixSort();
                    // Timing the Radix Sort Call
                    long RadixSortStartTime = System.nanoTime();
                    Number6.radixSort(dataClone6);
                    long RadixSortEndTime = System.nanoTime();
                    // Create a Variable to Hold Sorted Array
                    String RsSorted = Arrays.toString(dataClone6);
                    // Calculating Run Time
                    double RadixSortRunTime = RadixSortEndTime - RadixSortStartTime;
                    // Converting From nanoseconds to seconds
                    double RadixSortInMilliSeconds = (double)(RadixSortRunTime/1000000.0000);
                    // Convert to an Integer for Line Chart
                    //int RSLC = (int) RadixSortInMilliSeconds;
                    // Create a Variable to Hold Radix Sort Run Time
                    String RunTimeRadixSortMilliSeconds = String.valueOf(RadixSortInMilliSeconds);
                    // Print Sorted Array (Radix Sort)
                    System.out.println("Array Sorted with Radix Sort: " + RsSorted);
                    // Print Run Time (Radix Sort)
                    System.out.println("Radix Sort Run Time: " + RunTimeRadixSortMilliSeconds + " milliseconds");
                    // Add to series data
                    radixSortSeries.getData().add(new XYChart.Data(0,0));
                    radixSortSeries.getData().add(new XYChart.Data(totalItems, RadixSortInMilliSeconds));
                    lineChart.getData().add(radixSortSeries);
                    speedsList.add(RadixSortInMilliSeconds);
                    namesList.add("Radix Sort");
                };

                System.out.println(speedsList);
                System.out.println(namesList);
                
                // Finding Fastest Algorithm
                String fastestAlgorithm = "";
                Double minSpeed = 0.0;
                Double minSpeed2 = speedsList.get(0);
                int index = 0;
                for (int i = 0; i < speedsList.size(); i++ ) {
                    if (minSpeed2 > speedsList.get(i)){
                        minSpeed2 = speedsList.get(i);
                        index = i;
                    }
                }
                // Creating a place to store fastest Algorithm
                String fastestAlgorithm2 = namesList.get(index);
                
                // Setting minSpeed and fastestAlgorithm
                minSpeed = minSpeed2;
                fastestAlgorithm = fastestAlgorithm2;
                
                // Re-setting the bottom rows with updated information
                label6.setText(fastestAlgorithm + " is the fastest algorithm in this scenario.");
                label7.setText("Speed: " + minSpeed + " milliseconds");
            }
           
        });
        
        Button button3 = new Button ("Clear");
        button3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                textField1.clear();
                textField2.clear();
                textField3.clear();
                //choiceBox1.setValue(null);
                //choiceBox2.setValue(null);
                //choiceBox1.getSelectionModel().isEmpty();
                //choiceBox2.getSelectionModel().isEmpty();
                //choiceBox1.getSelectionModel().clearSelection();
                //choiceBox2.getSelectionModel().clearSelection();
                if(radioButton1.isSelected() == true){
                    radioButton1.setSelected(false);
                    choiceBox1.setDisable(false);
                    choiceBox2.setDisable(false);
                };
                //radioButton1.setSelected(false);
                lineChart.getData().clear();
                speedsList.clear();
                namesList.clear();
                label6.setText("");
                label7.setText("");
                boolean isMyComboBoxEmpty1 = (choiceBox1.getValue() == null);
                if(isMyComboBoxEmpty1 == false){
                   //choiceBox1.getSelectionModel().clearSelection();
                   choiceBox1.setValue(null);
                };
                boolean isMyComboBoxEmpty2 = (choiceBox2.getValue() == null);
                if(isMyComboBoxEmpty2 == false){
                   //choiceBox2.getSelectionModel().clearSelection();
                   choiceBox2.setValue(null);
                };
            }
            
        
        });

        //  Set Zero Row to gridPane
        gridPane.add(label1, 0, 0, 2, 1);
        gridPane.add(textField1, 2, 0, 1, 1);
        
        // Set One Row to gridPane
        gridPane.add(label2, 0, 1, 2, 1);
        gridPane.add(textField2, 2, 1, 1, 1);
        gridPane.add(label3, 3, 1, 1, 1);
        gridPane.add(textField3, 4, 1, 1, 1);
        
        // Set Two Row to gridPane
        gridPane.add(label4, 0, 2, 2, 1);
        gridPane.add(choiceBox1, 2, 2, 1, 1);
        gridPane.add(label5, 3, 2, 1, 1);
        gridPane.add(choiceBox2, 4, 2, 1, 1);
        
        // Set Three Row to gridPane
        gridPane.add(radioButton1, 0, 4, 1, 1);
        gridPane.add(button2, 2, 4, 1, 1);
        gridPane.add(button3, 4, 4, 1, 1);
        
        // Set Line Chart to gridPane
        gridPane.add(lineChart, 0, 7, 5, 5);
        
        // Set Bottom Rows to gridPane
        gridPane.add(label6, 1, 14, 3, 1);
        gridPane.add(label7, 1, 15, 2, 1);
    }
    
}
