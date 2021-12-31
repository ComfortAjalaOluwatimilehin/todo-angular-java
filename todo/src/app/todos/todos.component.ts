import { Component, OnInit } from '@angular/core';
import { from, Observable } from 'rxjs';
import { TodoService } from '../todo.service';
import { ITodo } from './todo.interface';
@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.sass'],
})
export class TodosComponent implements OnInit {
  todos$: Observable<ITodo[]> = from([]);
  selectedTodo: ITodo | undefined;
  newTodo: ITodo = { done: false } as ITodo;
  constructor(private service: TodoService) {}
  private async getTodos() {
    this.todos$ = this.service.getTodos();
  }
  selectTodo(todo: ITodo) {
    this.selectedTodo = todo;
    this.newTodo  = {...todo}
  }
  cancelSelectedTodo(): void {
    this.selectedTodo = undefined;
  }
  deleteSelectedTodo(): void {
    if (this.selectedTodo) {
      this.service.deleteTodo(this.selectedTodo.id).subscribe(() => {
        this.selectedTodo = undefined;
        this.getTodos();
      });
    }
  }
  updateTodo() {
    if (this.selectedTodo) {
      const body: Partial<ITodo> = { ...this.newTodo };
      this.service.updateTodo(this.selectedTodo.id, body).subscribe(() => {
        this.selectedTodo = undefined;
        this.newTodo =  { done: false } as ITodo;
        this.getTodos();
      });
    }
  }
  saveNewTodo() {
    if (
      this.newTodo.title &&
      this.newTodo.content &&
      typeof this.newTodo.done === 'boolean'
    ) {
      this.service.createTodo({ ...this.newTodo } as ITodo).subscribe(() => {
        this.newTodo = { done: false } as ITodo;
        this.getTodos();
      });
    } else {
      alert('Todo is invalid');
    }
  }
  ngOnInit(): void {
    this.getTodos();
  }
}
