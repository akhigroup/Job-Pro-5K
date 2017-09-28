package com.nmerris.roboresumedb.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    // a role always 'owns' its Person or Recruiter, it's just more logical this way if you ask me
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<Person> persons;

    public Role() {
        persons = new HashSet<>();
    }

    // necessary! using this to compare a Person's role in some places
    @Override
    public String toString() {
        return role;
    }


    // helper methods... prob. don't need all these
    public void addPerson(Person user) {
        persons.add(user);
    }

    public void removePerson(Person user) {
        persons.remove(user);
    }

    public void addPersons(HashSet<Person> users) {
        this.persons.addAll(users);
    }

    public void removePersons(HashSet<Person> users) {
        this.persons.removeAll(users);
    }


    // normal getters/setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(HashSet<Person> users) {
        this.persons = users;
    }


}
