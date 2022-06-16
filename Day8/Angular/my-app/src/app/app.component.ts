import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
  name = "Joan";
  items = ["mango", "apple", "grape"];
  users = [
    {name: "Joan", age: 20, gender: "Male"},
    {name: "Jack", age: 21, gender: "Male"},
    {name: "Jill", age: 25, gender: "Female"}
  ];
}
