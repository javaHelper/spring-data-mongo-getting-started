package com.keysoft.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.keysoft.mongodb.model.Application;
import com.keysoft.mongodb.model.Release;
import com.keysoft.mongodb.model.Ticket;
import com.keysoft.mongodb.repositories.ApplicationRepository;
import com.keysoft.mongodb.repositories.ReleaseRepository;
import com.keysoft.mongodb.repositories.TicketRepository;

@RestController
@RequestMapping(value = "/tza")
public class TzaController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // ************** Methods for Applications *************************
    @GetMapping(value = "/applications")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @GetMapping(value = "/applications/{id}")
    public Optional<Application> getApplicationById(@PathVariable("id") String id) {
        return applicationRepository.findById(id);
    }

    @PostMapping(value = "/applications")
    public Application addNewApplication(@RequestBody Application application){
        return applicationRepository.save(application);
    }

    @PutMapping(value = "/applications/{id}")
    public Application updateApplication(@PathVariable("id") String id, @RequestBody Application application){
        application.setId(id);
        return applicationRepository.save(application);
    }

    @DeleteMapping(value = "/applications/{id}")
    public void deleteApplication(@PathVariable("id") String id) {
        applicationRepository.deleteById(id);
    }

    // ************** Methods for Tickets *************************
    @GetMapping(value = "/tickets")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping(value = "/tickets/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") String id) {
        return ticketRepository.findById(id);
    }

    @PostMapping(value = "/tickets")
    public Ticket addNewApplication(@RequestBody Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @PutMapping(value = "/tickets/{id}")
    public Ticket updateApplication(@PathVariable("id") String id, @RequestBody Ticket ticket){
        ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping(value = "/tickets/{id}")
    public void deleteTicket(@PathVariable("id") String id) {
        ticketRepository.deleteById(id);
    }

    // ************** Methods for Releases *************************
    @RequestMapping(value = "/releases")
    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    @RequestMapping(value = "/releases/{id}")
    public Optional<Release> getReleaseId(@PathVariable("id") String id) {
        return releaseRepository.findById(id);
    }

    @RequestMapping(value = "/releases", method = RequestMethod.POST)
    public Release addNewRelease(@RequestBody Release release){
        return releaseRepository.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.PUT)
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release){
        release.setId(id);
        return releaseRepository.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.DELETE)
    public void deleteRelease(@PathVariable("id") String id) {
        releaseRepository.deleteById(id);
    }

}
