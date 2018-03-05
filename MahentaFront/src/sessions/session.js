import {HttpClient, json} from 'aurelia-fetch-client'

export class session{

  sessionData = {}
    movieList=[]
    
    constructor() {
        let client = new HttpClient();
        client.fetch('http://localhost:8080/movies')
			.then(response => response.json())
			.then(movies => this.movieList = movies);
        
    }

  addSession(){

    let client = new HttpClient();


    client.fetch('http://localhost:8080/sessions/add', {
      'method': "POST",
      'body': json(this.sessionData)
    })
      .then(response => response.json())
      .then(data =>{
        console.log("Server saatis" + data.movie_id);
      });
    console.log("method executed")
  }

}
