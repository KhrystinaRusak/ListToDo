import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class Task implements Serializable {
        // A String that holds the title of a task and it cannot be empty or null.
        private String title;
        // A String that holds the name of project associated with task, and it could be an empty string.
        private String project;
        // A boolean value, if true: the task is completed, otherwise false.
        private boolean complete;
        // The due date of the task as yyyy-mm-dd format
        private LocalDate dueDate;


        /**
         * Creating an object of Task class
         */
        public Task(String title, String project, LocalDate dueDate) {

            this.setTitle(title);
            this.setProject(project);
            this.complete = false;
            this.setDueDate(dueDate);
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) throws NullPointerException {
            if (title.trim().equals("") || title == null) {
                throw new NullPointerException("REQUIRED: Title can not be empty.");
            }
            this.title = title.trim();
        }

        public String getProject() {
            return this.project;
        }

        public void setProject(String project) {
            this.project = project.trim();
        }

        /**
         * A method to get the completed status of task
         * if the task is marked as completed, otherwise it will return false
         */
        public boolean isComplete() {
            return this.complete;
        }

        /**
         * A method to mark a task as in complete
         * the updated value of the field complete
         */
        public boolean markInComplete() {
            this.complete = false;
            return this.complete;
        }

        /**
         * A method to mark a task as completed the updated value of the field complete
         */
        public boolean markCompleted() {
            this.complete = true;
            return this.complete;
        }

        /**
         * A method to get the due date of the task
         * @return the due date of task as LocalDate object
         */
        public LocalDate getDueDate() {
            return dueDate;
        }

        /**
         * A method to set the due date of a task
         * @param dueDate The due date of the task as yyyy-mm-dd format
         * @throws DateTimeException if given date is a past date
         */
        public void setDueDate(LocalDate dueDate) throws DateTimeException {
            // Throw DateTimeException if past date is given
            if (dueDate.compareTo(LocalDate.now())<0) {
                throw new DateTimeException("Past Date not allowed");
            }

            //Ensure dueDate is saved as yyyy-MM-dd
            DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
        }

        /**
         * A method to get the task data as formatted string to display in multiple line formatted string of all fields of a task
         */
        public String formattedStringOfTask() {
            return (
                    "\nTitle     : " + title +
                            "\nProject   : " + project +
                            "\nStatus    : " + (complete?"Completed":"NOT COMPLETED") +
                            "\nDue Date  : " + dueDate +
                            "\n");
        }
    }