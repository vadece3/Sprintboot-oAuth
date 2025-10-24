package com.vice.springboot.entries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

public class EntriesController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final EntriesService entriesService;

    @Autowired
    public EntriesController(EntriesService entriesService) {
        this.entriesService = entriesService;
    }

    @RequestMapping(path = "api/v1/entries1")
    @GetMapping
    public List<Entries> getEntries1() {
        return entriesService.getEntries1();
    }

    @RequestMapping(path = "api/v1/entries2")
    @GetMapping
    public List<Entries> getEntries2() {
        return entriesService.getEntries2();
    }

    @RequestMapping(path = "api/v1/storeNewEntries")
    @PostMapping
    public String postEntries(@RequestBody Entries entries) {
        entriesService.addNewEntries(entries);
        return "New Entries Added";
    }

    @RequestMapping(path = "api/v1/deleteEntries/{entriesId}")
    @DeleteMapping
    public void deleteEntries(@PathVariable("entriesId") Integer entriesId) {
        entriesService.deleteEntries(entriesId);
    }

    @RequestMapping(path = "api/v1/deleteEntries")
    @DeleteMapping
    public void deleteEntries1(@RequestBody Integer entriesId) {
        entriesService.deleteEntries(entriesId);
    }

    @RequestMapping(path = "api/v1/updateEntries/{entriesId}")
    @PutMapping
    public void updateEntries1(
            @PathVariable("entriesId") Integer entriesId,
            @RequestParam(required = false) Integer consumerId,
            @RequestParam(required = false) Integer projectId,
            @RequestParam(required = false) String dateOfentry,
            @RequestParam(required = false) String hourOfEntry) {
        entriesService.updateEntries(entriesId, consumerId, projectId, dateOfentry, hourOfEntry);
    }

    @RequestMapping(path = "api/v1/updateEntries")
    @PutMapping
    public void updateEntries2(
            @RequestBody Integer entriesId,
            @RequestParam(required = false) Integer consumerId,
            @RequestParam(required = false) Integer projectId,
            @RequestParam(required = false) String dateOfentry,
            @RequestParam(required = false) String hourOfEntry) {
        entriesService.updateEntries(entriesId, consumerId, projectId, dateOfentry, hourOfEntry);
    }

}

