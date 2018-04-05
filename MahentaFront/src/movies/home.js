import 'bootstrap';
import {HttpClient} from 'aurelia-fetch-client'
import environment from '../environment'

export class Home {

     movieList = []
    
     activate(){
         let client = new HttpClient();
       client.fetch(environment.baseUrl+'/movies')
	 		.then(response => response.json())
	 		.then(movies => this.movieList = movies);
     }
    
    constructor() {
	this.message = "tulemast filme vaatama"
	}
}