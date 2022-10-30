package com.example.prkt5upseva.Models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="password_id")
    private Password password;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Post post;

    @ManyToMany
    @JoinTable(name = "job_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> jobs;

    public Person(String name, Password password, Post post) {
        this.name = name;
        this.password = password;
        this.post = post;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public Post getPost() {
        return post;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}