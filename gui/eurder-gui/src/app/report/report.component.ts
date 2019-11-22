import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  report: any;

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.orderService.getReport().subscribe(value => this.report = value)
  }

}
