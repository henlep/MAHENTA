import 'bootstrap'
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
        console.log("saadeti" + data.MovieTitle);
      });
    console.log("method execute")
  }

}
