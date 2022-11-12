package pe.isil.springdatajpademo.application;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name="tbl_application",uniqueConstraints = {@UniqueConstraint(name = "name_unique",columnNames = "vc_name")})
@Entity
public class Application {

    private static final String USER="SYS_USER";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="vc_name",nullable = false,length = 100)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(name="app_database",nullable = false,length = 100)
    private String database;

    @Column(name="app_language",nullable = false,length = 100)
    private String language;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    @PostPersist
    public void postPersist(){
        this.createdAt = new Date();
        this.createdBy= USER;
    }

    @PrePersist
    public void validar(){
        if(Objects.equals(this.language, "PHP")){
            System.out.println("ACA NO NOS GUSTA PHP, PERO LO TOLERAMOS");
        }
    }

    @PostUpdate
    public void postUpdate(){
        this.updatedAt= new Date();
        this.updatedBy = USER;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
