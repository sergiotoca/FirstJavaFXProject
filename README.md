# JavaFX Seating Chart Application

This is a JavaFX application that allows you to assign seats to students in a 3x3 seating chart. 

## Functionality

The application provides the following features:

- Click on a seat to assign a student to that seat
- Each seat is represented by a rectangle and a label that displays the name of the assigned student
- The color of the rectangle can be selected from a drop-down list of available colors
- The application prevents assigning a seat to a student if the selected color has already been used for another student
- An error message is displayed if a name or color is not provided or if all seats are already assigned
- The application is implemented using the Model-View-Controller (MVC) design pattern

## How to use

To run the application, simply execute the Main class. The GUI will appear, and you can start assigning seats to students. 

## Code

The code is implemented in the `MainSceneController` class. The `initialize` method sets up the seating chart, and the `assignSeat` method is called when a seat is clicked. The `Student` and `Seat` classes are used to represent the assigned students and their seats, respectively.

## Dependencies

This application uses JavaFX for the GUI. It requires Java 8 or higher to run.
