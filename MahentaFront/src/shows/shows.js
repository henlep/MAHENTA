import {HttpClient} from 'aurelia-fetch-client'
import {inject, bindable} from 'aurelia-framework';

export class Home {
    showList = [];
    cinemaList = [];
    minDate;
    maxDate;

    @bindable selectedCinema = "";
    @bindable searchTerm = "";
    @bindable selectedDate = "";
    
    activate(){
        
        
        var today = new Date().toISOString();
        var dateS = today.substring(0,10);
        this.minDate=dateS
        
        var maxDay = new Date();
        
        maxDay = new Date(maxDay.getTime()+(2*24*60*60*1000)).toISOString();
        var maxS = maxDay.substring(0,10);
        console.log(maxS)
        this.maxDate = maxS;
        
        
        let client = new HttpClient();
        client.fetch('http://localhost:8080/showsDate?date='+dateS)
			.then(response => response.json())
			.then(shows => this.showList = shows);
        
        client.fetch('http://localhost:8080/cinemas?date='+dateS)
			.then(response => response.json())
			.then(cinemas => this.cinemaList = cinemas);     
        
        
     }

    getMin(){
        return "2018-04-08"
    }

    dateChanged(date){
        this.showList = [];
        this.cinemaList = [];
        let client = new HttpClient();
        client.fetch('http://localhost:8080/showsDate?date='+date)
			.then(response => response.json())
			.then(shows => this.showList = shows);
        
        client.fetch('http://localhost:8080/cinemas?date='+date)
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
