import {HttpClient} from 'aurelia-fetch-client'
import {inject, bindable} from 'aurelia-framework';

export class Home {
    showList = [];

    @bindable searchTerm = "";
    
    activate(){
        let client = new HttpClient();
        client.fetch('http://localhost:8080/shows')
			.then(response => response.json())
			.then(shows => this.showList = shows);
    

        
        
        
        
        
     }

    clearFilter(){
    this.searchTerm = "";
    }
    
	constructor() {
        
        
		
        
        
        
	}

    filterFunc(searchExpression, value){
     
     let itemValue = value.Title;
     if(!searchExpression || !itemValue) return false;
     
     return itemValue.toUpperCase().indexOf(searchExpression.toUpperCase()) !== -1;
     
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