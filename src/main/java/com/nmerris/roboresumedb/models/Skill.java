package com.nmerris.roboresumedb.models;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.jmx.export.annotation.ManagedMetric;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill implements Comparable<Skill> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(max = 50)
    private String skill;

//    @NotEmpty
    private String rating;

    // Skill owns Job
    @ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER)
    private Collection<Job> jobs;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    private Collection<Person> persons;


    public Skill() {
        jobs = new HashSet<>();
        persons = new HashSet<>();
    }

    // just compare by ids, could compare with anything we want
    @Override
    public int compareTo(Skill other) {
        return getSkill().compareToIgnoreCase(other.getSkill());
    }


    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}
