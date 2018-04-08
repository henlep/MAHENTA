import {HttpClient} from 'aurelia-fetch-client'
import {inject, bindable} from 'aurelia-framework';

export class Home {
    showList = [];
    cinemaList = [];

    @bindable selectedCinema = "";
    @bindable searchTerm = "";
    
    activate(){
        let client = new HttpClient();
        client.fetch('http://localhost:8080/shows')
			.then(response => response.json())
			.then(shows => this.showList = shows);
        
        client.fetch('http://localhost:8080/cinemas?date=2018-04-09')
			.then(response => response.json())
			.then(cinemas => this.cinemaList = cinemas);
    

        
        
        
        
        
     }

    clearFilter(){
    this.searchTerm = "";
    }
    
	constructor() {
        
        
		
        
        
        
	}

    filterFunc(searchExpression, value, selectedCinema){
     
     let itemValue = value.Title;
     let itemCinema = value.Cinema
     let matches;
     if(!searchExpression || !itemValue) return false;
     
     if(selectedCinema==""){
        
     matches = itemValue.toUpperCase().indexOf(searchExpression.toUpperCase()) !== -1 ;
     } else {
         
         matches = itemValue.toUpperCase().indexOf(searchExpression.toUpperCase()) !== -1 && itemCinema==selectedCinema;
     }
        
    
     return matches
     
  }
    
    
}
export class FilterValueConverter {
  toView(array, searchTerm, filterFunc, selectedCinema) {
      console.log(selectedCinema)
	
    return array.filter((item) => {
	
	  let matches = searchTerm && searchTerm.length > 0 ? filterFunc(searchTerm,item, selectedCinema): true;
	  				
	  return matches;
    });
  }
}