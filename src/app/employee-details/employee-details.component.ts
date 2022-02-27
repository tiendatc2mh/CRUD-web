import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  employeeId!: number;
  employee!: Employee;
  
  constructor(private router:Router,private route: ActivatedRoute, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeId=this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.employeeId).subscribe(data=>{
      this.employee=data;
      console.log(data);
    }, error => console.log(error));

  }
  employeeList(){
    this.router.navigate(['/employees']);
  }

}
