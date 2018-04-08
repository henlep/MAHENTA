export class App {
  constructor() {
    //this.message = 'Hello World!';
  }
    
    configureRouter(config, router){
        this.router = router;
        config.title = "MAHENTA";
        config.map([
           {route: ['', 'home'], name:'home', moduleId: 'home/index', title: 'home',  nav:true },
            {route:'movies', name:'movies', moduleId:'movies/home', title:'movies', nav: true},
            {route:'addMovie', name:'addMovie', moduleId:'movies/addMovie', title:'addMovie', nav: true},
          {route: 'addSession', name:'addSession', moduleId:'sessions/session', title:'addSession', nav:true},
            {route:'sessions', name:'sessions', moduleId:"sessions/sessions", title:'sessions', nav:true},
            {route:'shows', name:'shows', moduleId:'shows/shows', title:'shows', nav:true}
            
        ]);
    }
}
