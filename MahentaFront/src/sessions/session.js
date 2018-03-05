import {HttpClient, json} from 'aurelia-fetch-client'

export class session{

  sessionData = {}

  addSession(){

    let client = new HttpClient();


    client.fetch('', {
      'method': "POST",
      'body': json(this.sessionData)
    })
      .then(response => response.json())
      .then(data =>{
        console.log("Server saatis" + data.MovieTitle);
      });
    console.log("method executed")
  }

}
