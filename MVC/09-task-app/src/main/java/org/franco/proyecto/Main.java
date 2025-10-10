package org.franco.proyecto;

import org.franco.proyecto.task.controller.TaskController;
import org.franco.proyecto.task.model.TaskRepository;
import org.franco.proyecto.task.view.TaskView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();
        TaskController controller = new TaskController(repository);
        TaskView taskView = new TaskView(controller);
        taskView.showMenu();
    }
}