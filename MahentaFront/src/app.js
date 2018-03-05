export class App {
  constructor() {
    //this.message = 'Hello World!';
  }
    
    configureRouter(config, router){
        this.router = router;
        config.title = "MAHENTA";
        config.map([
           {route: ['', 'home'], name:'home', moduleId: 'home/index' },
            {route:'movies', name:'movies', moduleId:'movies/home', nav: true},
            {route:'addMovie', name:'addMovie', moduleId:'movies/addMovie', nav: true},
          {route: 'sessions', name:'sessions', moduleId:'sessions/session', nav:true}
            
        ]);
    }
}
