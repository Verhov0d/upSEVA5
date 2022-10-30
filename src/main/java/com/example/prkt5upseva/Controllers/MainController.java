package com.example.prkt5upseva.Controllers;

import com.example.prkt5upseva.Repository.JobRepository;
import com.example.prkt5upseva.Models.Job;
import com.example.prkt5upseva.Models.Password;
import com.example.prkt5upseva.Models.Person;
import com.example.prkt5upseva.Models.Post;
import com.example.prkt5upseva.Repository.PasswordRepository;
import com.example.prkt5upseva.Repository.PersonRepository;
import com.example.prkt5upseva.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/person")
    public String Main(Model model){
        Iterable<Password> password = passwordRepository.findAll();
        ArrayList<Password> passwordArrayList = new ArrayList<>();
        for (Password pass:
                password) {
            if (pass.getOwner() == null) {
                passwordArrayList.add(pass);
            }
        }
        model.addAttribute("password", passwordArrayList);
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        Iterable<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("person", people);
        return "person";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String name,
                              @RequestParam String passwordName,
                              @RequestParam String postName,
                              Model model)
    {
        System.out.println(name);
        Password password = passwordRepository.findByPasswordName(passwordName);
        Post post = postRepository.findByNameContaining(postName);
        System.out.println(password.getId());
        Person person = new Person(name, password, post);
        personRepository.save(person);
        return "redirect:/person";
    }

    @PostMapping("/person/addJob")
    public String blogAdd(@RequestParam String nameN,
                          @RequestParam String jobName, Model model)
    {
        Job job = jobRepository.findByNameContaining(jobName);
        Person person = personRepository.findByNameContaining(nameN);
        person.getJobs().add(job);
        personRepository.save(person);
        return "redirect:/person";
    }
}