package controllers;

import models.*;
//import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
        return redirect(routes.Application.tasks());
    }

    public static Result tasks() {
        return ok( views.html.index.render(Task.all(), taskForm) );
    }

    public static Result newTask() {

        /*
            Use bindFromRequest to create a new form filled with the request data
         */
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                views.html.index.render(Task.all(), filledForm)
            );
        } else { // no errors, successfully create the new task with the form data
            Task.create(filledForm.get());
            return redirect(routes.Application.tasks());
        }

    }

    public static Result deleteTask(Long id) {
        return TODO;
    }

}
