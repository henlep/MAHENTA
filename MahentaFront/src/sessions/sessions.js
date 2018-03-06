import {HttpClient} from 'aurelia-fetch-client'

export class Home {
    sessionList = [];
    movieList =[]
    
    activate(){
        let client = new HttpClient();
        client.fetch('http://localhost:8080/sessions')
			.then(response => response.json())
			.then(sessions => this.sessionList = sessions);
    

        client.fetch('http://localhost:8080/movies')
	 		.then(response => response.json())
	 		.then(movies => this.movieList = movies);
        
        
        
        
        
     }
    
	constructor() {
        
        
		
        
        
        
	}
    
    
}