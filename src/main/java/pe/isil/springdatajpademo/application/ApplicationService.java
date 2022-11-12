package pe.isil.springdatajpademo.application;

import java.util.List;

public interface ApplicationService {

    void addApplication(Application app);

    void updateApplication(Application app, Long id);

    void deleteApplication(Long id);

    List<Application> getApplications();

    Application getApplicationByName();

    Application getApplicationByDatabaseAndLanguage(String database,String language);

}
