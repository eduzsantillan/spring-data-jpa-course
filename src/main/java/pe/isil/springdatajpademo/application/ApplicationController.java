package pe.isil.springdatajpademo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApplicationController {


    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getall")
    public List<Application> getAllApplication(){
        return applicationService.getApplications();
    }

    @GetMapping("/getbydbandlanguage")
    public Application getByDatabaseAndLanguage(@RequestParam String db, @RequestParam String lang){
        return applicationService.getApplicationByDatabaseAndLanguage(db,lang);
    }


    @PostMapping("/addapp")
    public void addApplication(@RequestBody Application app){
        applicationService.addApplication(app);
    }


    @PostMapping("/updateapp")
    public void updateAppplication(@RequestBody Application app, @RequestParam Long id){
        applicationService.updateApplication(app,id);
    }

    @DeleteMapping("/deleteapp")
    public void deleteApplication(@RequestParam Long id){
        applicationService.deleteApplication(id);
    }



}
