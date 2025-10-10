package org.franco.proyecto.task.view;

import org.franco.proyecto.task.controller.TaskController;
import org.franco.proyecto.task.exceptions.TaskException;
import org.franco.proyecto.task.exceptions.TaskValidationException;
import org.franco.proyecto.task.model.Task;

import java.util.Scanner;

public class TaskView {

    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public  void showMenu(){
        while (true){
            System.out.println("\n Gesti'on de Tareas");
            System.out.println("1. Agregar Tareas");
            System.out.println("2. Eliminar de Tareas");
            System.out.println("3. Actualizar de Tareas");
            System.out.println("4. Mostrar Tareas");
            System.out.println("5. Actualizar estado de las tareas");
            System.out.println("6. Mostrar tareas completadas");
            System.out.println("7. Mostrar tareas pendietes");
            System.out.println("8. Salir");
            System.out.println("Seleccione una opcion");
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    addTaskView();
                    break;
                case "2":
                    removeTaskView();
                    break;
                case "3":
                    updateTaskView();
                    break;
                case "4":
                    showTaskView();
                    break;
                case "5":
                    updateCompletedTaskView();
                    break;
                case "6":
                    showCompletedTaskView();
                    break;
                case "7":
                    showPendingTaskView();
                    break;
                case "8":
                    System.out.println("Saliendo del sistema");
                return;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        }
    }

    private Task getTaskInput(){
        String id;
        String title;
        String description;
        Boolean completed= null;
        do {
            System.out.println("Ingrese el id: ");
            id = scanner.nextLine();
            if (id.isEmpty()){
                System.out.println("El id no puede estar vacio");
            }
        }while (id.isEmpty());

        do {
            System.out.println("Ingrese el titulo: ");
            title = scanner.nextLine();
            if (title.isEmpty()){
                System.out.println("El titulo no puede estar vacio");
            }
        }while (title.isEmpty());

        do {
            System.out.println("Ingrese la descripcion: ");
            description = scanner.nextLine();
            if (description.isEmpty()){
                System.out.println("la descripcion no puede estar vacio");
            }
        }while (description.isEmpty());

        while (completed==null){
            System.out.println("Esta completada? true / false");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")){
                completed= true;
            }else if (input.equals("false")){
                completed=false;
            }else{
                System.out.println("El valor ingresado no es el incorrecto, 'true' o 'false'");
            }
        }



        return new Task(id,title,description,completed);
    }

    public void updateTaskView(){
        try {
            Task task = getTaskInput();
            taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(),task.getCompleted());
            System.out.println("Tarea actualizada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (Exception e){
            System.err.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void showTaskView(){
        try {
            System.out.println("\nLa lista de tarea");
            this.taskController.showTasks();
            System.out.println("Tarea eliminada exitosamente.");
        } catch (TaskValidationException | TaskException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado, por favor contacta con soporte.");
            e.printStackTrace();
        }
    }

    public void removeTaskView(){
        try {
            System.out.println("Ingrese el Id a eliminar: ");
            String id = scanner.nextLine();
            this.taskController.removeTask(id);
            System.out.println("Tarea eliminada exitosamente.");
        } catch (TaskValidationException | TaskException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado, por favor contacta con soporte.");
            e.printStackTrace();
        }
    }

    public void addTaskView(){
        try {
            Task task = getTaskInput();
            taskController.addTask(task.getId(), task.getTitle(), task.getDescription(),task.getCompleted());
            System.out.println("Tarea agregada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (Exception e){
            System.err.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void updateCompletedTaskView(){
        try {
            System.out.println("Ingrese al ID de la tarea");
            String id = scanner.nextLine();

            Boolean completed= null;
            while (completed==null){
                System.out.println("Esta completada? true / false");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("true")){
                    completed= true;
                }else if (input.equals("false")){
                    completed=false;
                }else{
                    System.out.println("El valor ingresado no es el incorrecto, 'true' o 'false'");
                }
            }
            taskController.updateTaskCompleted(id, completed);
            System.out.println("Estado de la tarea actualizado correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (Exception e){
            System.err.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void showCompletedTaskView(){
        try {
            System.out.println("Tareas Completadas");
            taskController.showCompletedTasks();
        }catch (TaskException | TaskValidationException e){
            throw new RuntimeException(e);
        }
    }

    public void showPendingTaskView(){
        try {
            System.out.println("Tareas pendientes");
            taskController.showPendingTasks();
        }catch (TaskException | TaskValidationException e){
            throw new RuntimeException(e);
        }
    }

}
