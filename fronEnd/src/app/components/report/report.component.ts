import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
 
import { ReportesPorUsuarioDTO } from '../models/ReportesPorUsuarioDTO';
import {ReportesPorUsuarioDTOservices}from '../services/ReportesPorUsuarioDTO.service';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Label } from 'ng2-charts';


@Component({
    selector: 'report',
    templateUrl:'./report.component.html',
    providers: [ ReportesPorUsuarioDTOservices]


})
export class ReportComponent implements OnInit{
    public estado;
    public listReport: Array<ReportesPorUsuarioDTO>
     public barChartOptions: ChartOptions = {
        responsive: true,
        // We use these empty structures as placeholders for dynamic theming.


        scales: { xAxes: [{}], yAxes: [{}] },
        plugins: {
          datalabels: {
            anchor: 'end',
            align: 'end',
          }
        }
      };
      public barChartLabels: Label[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
      public barChartType: ChartType = 'bar';
      public barChartLegend = true;
      public barChartPlugins = [pluginDataLabels];
    
      public barChartData: ChartDataSets[] = [
        { data: [65, 59, 80, 81, 56, 55, 40], label: 'Serie A' }
      ];
      
  
  
  
    constructor(private _router: Router, private _activatedRoute: ActivatedRoute ,
        private _reportesDTOservices: ReportesPorUsuarioDTOservices) {
    }
    ngOnInit(){
        this.estado = localStorage.getItem('estado');
        
        if (this.estado=='true'){
            console.log('los componentes estan cargados');
            const data = [];
            const label = [];
            this._reportesDTOservices.reporteUsuario(1).subscribe(
                response=>{
                        this.listReport=response; 
                        console.log(this.listReport);
                        let contador = 0; 

                        this.listReport.forEach(function(element) {
                            console.log(element.cantidad);
                          data.push(element.cantidad);
                          label.push(element.nombres); 
                          });
                          this.barChartData[0].data = data;
                          this.barChartLabels=label;
                       
                },error =>{
                }
            )
        }else if (this.estado=='false'){
                this._router.navigate(['/login']);
        }
    }

    onGenerar(){
     
    }





    //event 
    public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public randomize(): void {
    // Only Change 3 values
    const data = [];
      data.push(50)
    this.barChartData[0].data = data;
  }
}