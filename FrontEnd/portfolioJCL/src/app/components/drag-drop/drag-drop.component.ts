import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';


@Component({
  selector: 'app-drag-drop',
  templateUrl: './drag-drop.component.html',
  styleUrls: ['./drag-drop.component.css']
})
export class DragDropComponent implements OnInit {

  idiomas:string[]  = [
    'Annyeonghaseyo',
    'Hello',
    'Ni Hao',
    'Bonjour',
    'Coreano',
    'Chino',
    'Francés',
    'Inglés'
  ];

  pronunciacion:string[]=[];
  escritura:string[]=[
    '안녕하세요',
    '你好',
    'שָׁלוֹם',
    'こんにちは'
  ];


  constructor() { }

  ngOnInit(): void {
  }

  drop(event: CdkDragDrop<string[]>) {
    if(event.previousContainer === event.container){
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    }else{
      transferArrayItem(event.previousContainer.data,
                        event.container.data,
                        event.previousIndex,
                        event.currentIndex);
    }
  }

}
