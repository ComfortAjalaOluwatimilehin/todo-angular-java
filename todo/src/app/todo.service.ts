import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ITodo } from './todos/todo.interface';
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http:HttpClient) {

   }

   getTodos():Observable<ITodo[]>{
      return this.http.get<ITodo[]>("http://localhost:8080/todos")
   }
  createTodo(todo:ITodo):Observable<any>{
    return this.http.post("http://localhost:8080/todos", todo)
  }
  updateTodo(id:string, todo:Partial<ITodo>):Observable<any>{
    return this.http.patch(`http://localhost:8080/todos/${id}`, todo)
  }
  deleteTodo(id:string):Observable<any>{
    return this.http.delete(`http://localhost:8080/todos/${id}`)
  }
}
