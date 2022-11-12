package pe.isil.springdatajpademo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getApplications() {

        return applicationRepository.findAll();
    }


    @Override
    public void addApplication(Application app) {

        Application appToFind = applicationRepository.findByName(app.getName());
        if( appToFind !=null){
            throw new IllegalStateException("Aplicacion ya registrada");
        }
        applicationRepository.save(app);

    }

    @Override
    public void updateApplication(Application app, Long id) {

        Optional<Application> appToUpdate = applicationRepository.findById(id);
        if(appToUpdate.isPresent()){
            appToUpdate.get().setName(app.getName()!=null? app.getName() : appToUpdate.get().getName());
            appToUpdate.get().setDescription(app.getDescription()!=null? app.getDescription() :appToUpdate.get().getDescription() );
            appToUpdate.get().setDatabase(app.getDatabase()!=null? app.getDatabase():appToUpdate.get().getDatabase());
            appToUpdate.get().setLanguage(app.getLanguage()!=null?app.getLanguage():appToUpdate.get().getLanguage());
            applicationRepository.save(appToUpdate.get());
        }
    }

    @Override
    public void deleteApplication(Long id) {
        Optional<Application> appToDelete = applicationRepository.findById(id);
        if(appToDelete.isPresent()){
            applicationRepository.deleteById(id);
        }
    }


    @Override
    public Application getApplicationByDatabaseAndLanguage(String database,String language) {
        return applicationRepository.findByDatabaseAndLanguage(database,language);

    }

    @Override
    public Application getApplicationByName() {
        return null;
    }
}
