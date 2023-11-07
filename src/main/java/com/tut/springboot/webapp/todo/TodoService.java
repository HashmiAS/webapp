package com.tut.springboot.webapp.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int count=0;
    static{
        todos.add(new Todo(++count,"anwar","Java","Nov 22", false));
        todos.add(new Todo(++count,"syed","Php","Dec 22", false));
        todos.add(new Todo(++count,"hashmi","Sql","Jan 22", false));
        todos.add(new Todo(++count,"hashmi","C++","Jan 12", true));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description, String targetDate, boolean status){
        Todo todo = new Todo(++count,username,description,targetDate,status);
        todos.add(todo);

    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() ==id;
        todos.removeIf(predicate); //predicate is a condition
    }
}
