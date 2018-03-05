import {HttpClient, json} from 'aurelia-fetch-client'

export class addMovie{
    movieData={}
    
    addMovie() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/movies/add', {
			'method': "POST",
			'body': json(this.movieData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.Title);
		});

		console.log("Method executed!")
	}
}