import {HttpClient} from 'aurelia-fetch-client'
import {inject, bindable} from 'aurelia-framework';

export class Home {
    showList = [];
    cinemaList = [];

    @bindable selectedCinema = "";
    @bindable searchTerm = "";
    
    activate(){
        let client = new HttpClient();
        client.fetch('http://localhost:8080/showsDate?date=2018-04-09')
			.then(response => response.json())
			.then(shows => this.showList = shows);
        
        client.fetch('http://localhost:8080/cinemas?date=2018-04-09')
			.then(response => response.json())
			.then(cinemas => this.cinemaList = cinemas);
    

        
        
        
        
        
     }

    openPage(url){
        var win = window.open(url, '_blank');
        win.focus();
    }

    clearFilter(){
    this.searchTerm = "";
    }
    
	constructor() {
        
        
		
        
        
        
	}

    filterFunc(searchExpression, value){
     
     let itemValue = value.Title;
     let matches;
     if(!searchExpression || !itemValue) return false;    
        
     matches = itemValue.toUpperCase().indexOf(searchExpression.toUpperCase()) !== -1 ;
      
    
     return matches
     
  }

    cinemaFunc(cinema, value){
                
        console.log("ss")
        matches = value.toUpperCase().indexOf(cinema.toUpperCase()) !== -1 ;
      
    
     return matches
    }
    
    
}
export class FilterValueConverter {
  toView(array, searchTerm, filterFunc) {
    return array.filter((item) => {
	
	  let matches = searchTerm && searchTerm.length > 0 ? filterFunc(searchTerm,item): true;
	  				
	  return matches;
    });
  }
}

export class CinemaValueConverter {
  toView(array, selectedCinema, filterFunc) {
      console.log(selectedCinema)
      
    return array.filter((item) => {
	  if (selectedCinema!=""){
	       let matches = item.Cinema==selectedCinema;
          return matches;
      }else {
          let matches = item.Cinema!="";
          return matches;
      }
	  				
	  
    });
  }
}