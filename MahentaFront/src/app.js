export class App {
  constructor() {
    this.message = 'Hello World!';
  }
    
    configureRouter(config, router){
        this.router = router;
        config.title = "MAHENTA";
        config.map([
           {route: ['', 'home'], name:'home', moduleId: 'home/index' },
            {route:'movies', name:'movies', moduleId:'movies/home', nav: true}
            
        ]);
    }
}
