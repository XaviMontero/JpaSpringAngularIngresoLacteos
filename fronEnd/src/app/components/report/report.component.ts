import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
 
import { ReportesPorUsuarioDTO } from '../models/ReportesPorUsuarioDTO';
import {ReportesPorUsuarioDTOservices}from '../services/ReportesPorUsuarioDTO.service';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Label } from 'ng2-charts';
import {ReportePorZonasDTO} from   '../models/ReportePorZonasDTO';
import { element } from '@angular/core/src/render3';


@Component({
    selector: 'report',
    templateUrl:'./report.component.html',
    styleUrls: ['./report.component.sass'],
    providers: [ ReportesPorUsuarioDTOservices]


})
export class ReportComponent implements OnInit{
    public estado;
    public listReport: Array<ReportesPorUsuarioDTO>;
    public listReportZona: Array<ReportePorZonasDTO>
    //Variables reporte 1 
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
      
  

      //variables del reporte 2 
      public barChartOptions2: ChartOptions = {
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
      public barChartLabels2: Label[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
      public barChartType2: ChartType = 'bar';
      public barChartLegend2 = true;
      public barChartPlugins2 = [pluginDataLabels];
    
      public barChartData2: ChartDataSets[] = [
        { data: [65, 59, 80, 81, 56, 55, 40], label: 'Tambo' },
        { data: [35, 15, 80, 85, 70, 65, 50], label: 'Totora' }
      ];

  
  
    constructor(private _router: Router, private _activatedRoute: ActivatedRoute ,
        private _reportesDTOservices: ReportesPorUsuarioDTOservices) {
    }
    ngOnInit(){
        this.estado = localStorage.getItem('estado');
        const dataReporteZona = [];
        const labelZona = [];
        const dataReporteZonaTow = [];
        const labelZonaTow = [];
        
        if (this.estado=='true'){
            console.log('los componentes estan cargados');
            const data = [];
            const label = [];

       
            this._reportesDTOservices.reporteUsuario(5).subscribe(
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
        this._reportesDTOservices.reporteZonas(5).subscribe(
          response=>{
               
                  this.listReportZona= response; 
                  this.listReportZona.forEach(function(report){
                      if(report.direccion=='Tambo'){
                        dataReporteZona.push(report.total); 
                        labelZona.push(report.dia); 
                      } if(report.direccion=='Totora'){

                        dataReporteZonaTow.push(report.total); 
                        labelZonaTow.push(report.dia); 
                      }
                  }); 
                this.barChartData2[0].data=dataReporteZona;
                this.barChartData2[1].data=dataReporteZonaTow;
                this.barChartLabels2=labelZona;
               

             

          },error=>{

          }
        );

        
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

 
}