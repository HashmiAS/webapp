package com.tut.springboot.webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUsername("hashmi");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    //method to allow adding new todo
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        String user=(String)model.get("name");
        Todo todo = new Todo(0, user,"","",true);
        model.put("todo",todo);
        return "todo";
    }

    //return value to list-todo jsp page
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        String user=(String)model.get("name");
        todoService.addTodo(user,todo.getDescription(),todo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET) //show update to-to page
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        String user=(String)model.get("name");
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST) //submit update to to-do
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String user=(String)model.get("name");
        todo.setUsername(user);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
