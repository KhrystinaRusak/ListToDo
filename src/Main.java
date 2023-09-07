import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "tasks.obj";

    public static void main(String args[]) {
        // An object of TodoList to hold all tasks and their data
        TodoList todoList = new TodoList();

        //A string to hold the choice that will be entered by the user
        String choice = "-27";

        try {
            Scanner input = new Scanner(System.in);

            // reading the date from task data file
            // if this is the first time, a message will be shown that no data file is found
            todoList.readFromFile(filename);

            Messages.showMessage("Welcome to ToDoList", false);

            while (!choice.equals("4")) {
                Messages.mainMenu(todoList.notCompletedCount(), todoList.completedCount());
                choice = input.nextLine();

                switch (choice) {
                    case 1 -> todoList.addTask();
                    case 2 -> todoList.editTask();
                    case 3 -> todoList.cancel();
                    case 4 -> todoList.completedCount();
                    case 5 -> todoList.notCompletedCount();
                    case 6 -> todoList.readTaskFromUser();
                    case 7 -> Messages.listAllTasksMenu();
                    case 8 -> System.exit(0);
                }
            }

            // saving the task details in data file
            // if this is the first time, a new task file will be created
            todoList.saveToFile(filename);
            Messages.byeMessage();

        } catch (Exception e) {
            Messages.showMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            todoList.saveToFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}