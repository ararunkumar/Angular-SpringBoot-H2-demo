import { Component, OnInit } from '@angular/core';

import { Employee } from './employee';
import { FormGroup, FormBuilder, FormControl, Validators, Form } from '@angular/forms';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  ngOnInit(): void {
    this.createForm();
    this.getData();
  }
  url: string = 'Employee';
  title = 'Angular Sample';
  employeeList: Map<any, any> | undefined 
  employee!: Employee; 
  myForm!: FormGroup; 

  constructor(private webService: EmployeeService, private formBuilder: FormBuilder) { }


  private createForm() {
    this.myForm = this.formBuilder.group({
      firstName: new FormControl(this.employee ? this.employee.firstName : '',  [
        Validators.required,
        Validators.minLength(3)        
      ]),
      coins: new FormControl(this.employee ? this.employee.coins : '', [
        Validators.required,
        Validators.min(1)        
      ])
    });
  }
   submitForm(data: FormGroup) {
    if (data.valid)
      this.addEmployee(data.value)
  }

  getData(): void {
    this.webService.get('getEmployeeCoins').subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
     // console.log(response.data);
      
      //this.employeeList = response.data
      //console.log(response);
      this.employeeList = response
    })
  }

  addEmployee(employee: Employee): void {
    if (this.employee)
    employee.id = this.employee.id
    console.log(employee);
    this.webService.post('addCoins', employee).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.getData()
      this.myForm.reset()
      this.employee === null
    },success => {
      message:"Added "+employee.coins+" coins to "+employee.firstName;
    }, () => {
    })
  }
}
