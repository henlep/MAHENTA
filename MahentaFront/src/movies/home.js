import {HttpClient} from 'aurelia-fetch-client'

export class Home {

    movieList = []
    
    activate(){
        let client = new HttpClient();
        client.fetch('http://localhost:8080/movies')
			.then(response => response.json())
			.then(movies => this.movieList = movies);
    }
    
	constructor() {
		this.message = "tulemast filme vaatama"
	}
}