package com.vice.springboot.entries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntriesService {

    private final EntriesRepository entriesRepository;

    @Autowired
    public EntriesService(EntriesRepository entriesRepository) {
        this.entriesRepository = entriesRepository;
    }

    public List<Entries> getEntries1() {
        return entriesRepository.findAll();
    }

    public List<Entries> getEntries2() {
        return List.of(
                new Entries(
                        1,
                        222,
                        22,
                        "testEntries",
                        "0"
                )
        );
    }

    public void addNewEntries(Entries entries) {
            entriesRepository.save(entries);
    }

    public void deleteEntries(Integer entriesId) {
        boolean exists = entriesRepository.existsById(entriesId);
        if (!exists) {
            throw new IllegalStateException(
                    "Entry with id " + entriesId + " does not exists");
        } else {
            entriesRepository.deleteById(entriesId);
        }
    }

    @Transactional
    public void updateEntries(
            Integer entriesId,
            Integer consumerId,
            Integer projectId,
            String dateOfentry,
            String hourOfEntry) {

        Entries entries = entriesRepository.findById(entriesId)
                .orElseThrow(() -> new IllegalStateException(
                        "Entry with id " + entriesId + " does not exist"));


        if (consumerId != null &&
                consumerId > 0 &&
                !Objects.equals(entries.getConsumerId(), consumerId)) {
            entries.setConsumerId(consumerId);
        }

        if (projectId != null &&
                projectId > 0 &&
                !Objects.equals(entries.getProjectId(), projectId)) {
            entries.setProjectId(projectId);
        }

        if (dateOfentry != null &&
                dateOfentry.length() > 0 &&
                !Objects.equals(entries.getDateOfentry(), dateOfentry)) {
            entries.setDateOfentry(dateOfentry);
        }

        if (hourOfEntry != null &&
                hourOfEntry.length() > 0 &&
                !Objects.equals(entries.getHourOfEntry(), hourOfEntry)) {
            entries.setHourOfEntry(hourOfEntry);
        }
    }

}

