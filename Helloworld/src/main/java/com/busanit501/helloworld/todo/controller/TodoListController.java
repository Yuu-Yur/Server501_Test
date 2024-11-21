package com.busanit501.helloworld.todo.controller;

import com.busanit501.helloworld.todo.dto.TodoDTO;
import com.busanit501.helloworld.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListController",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //화면 전달.

        // 서비스 계층을 이용해서, 디비 연결 하기 전,
        // 더미 데이터를 받아와서, 확인
        System.out.println("doGet : TodoListController");
        List<TodoDTO> todoList = TodoService.INSTANCE.getList();
        // 화면에 전달하는 방법,
        request.setAttribute("list", todoList);

        //방법1
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
//        dispatcher.forward(request,response);
        //방법2
        request.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
                .forward(request, response);
    }
}