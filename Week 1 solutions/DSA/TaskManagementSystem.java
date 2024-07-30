
public class TaskManagementSystem {

    public static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        public void display() {
            System.out.println("Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status);
        }
    }

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }
    public static class LinkedList {
        private Node head;

        public LinkedList() {
            head = null;
        }

        public void add(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public Task search(String taskId) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.getTaskId().equals(taskId)) {
                    return temp.task;
                }
                temp = temp.next;
            }
            return null;
        }

        public void displayAllTasks() {
            Node temp = head;
            if (temp == null) {
                System.out.println("No tasks!");
                return;
            }
            while (temp != null) {
                temp.task.display();
                temp = temp.next;
            }
        }

        public void deleteTaskById(String taskId) {
            if (head == null) {
                System.out.println("Empty!");
                return;
            }

            if (head.task.getTaskId().equals(taskId)) {
                head = head.next;
                return;
            }

            Node prev = null;
            Node curr = head;
            while (curr != null && !curr.task.getTaskId().equals(taskId)) {
                prev = curr;
                curr = curr.next;
            }

            if (curr == null) {
                System.out.println("Task not found.");
                return;
            }

            prev.next = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList taskList = new LinkedList();

       
        taskList.add(new Task("T1", "Do this", "Incomplete"));
        taskList.add(new Task("T2", "and that", "Complete"));
        taskList.add(new Task("T3", "sleep", "Incomplete"));

        
        System.out.println("All Tasks are:");
        taskList.displayAllTasks();

        System.out.println("\nSearching for task T002:");
        Task task = taskList.search("T2");
        if (task != null) {
            task.display();
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task T2:");
        taskList.deleteTaskById("T2");

        System.out.println("\nAll Tasks after deletion:");
        taskList.displayAllTasks();
    }
}
