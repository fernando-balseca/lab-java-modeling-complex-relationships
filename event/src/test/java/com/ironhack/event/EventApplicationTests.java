package com.ironhack.event;

import com.ironhack.event.model.*;
import com.ironhack.event.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EventApplicationTests {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private ExpositionRepository expositionRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private SpeakerRepository speakerRepository;

	@Test
	public void saveConference_conferenceAndGuestsAndSpeakers_correctSave() {
		Conference conference = new Conference(LocalDate.of(2025, 3, 20), 75, "Madrid", "Conference Test");

		Guest guest1 = new Guest("John", Status.ATTENDING, conference);
		Guest guest2 = new Guest("David", Status.NOT_ATTENDING, conference);
		Guest guest3 = new Guest("Alice", Status.NO_RESPONSE, conference);
		conference.getGuests().add(guest1);
		conference.getGuests().add(guest2);
		conference.getGuests().add(guest3);

		Speaker speaker1 = new Speaker("Diego", 45, conference);
		Speaker speaker2 = new Speaker("Bob", 30, conference);
		conference.getSpeakers().add(speaker1);
		conference.getSpeakers().add(speaker2);

		conferenceRepository.save(conference);
		guestRepository.save(guest1);
		guestRepository.save(guest2);
		guestRepository.save(guest3);
		speakerRepository.save(speaker1);
		speakerRepository.save(speaker2);

		Optional<Conference> conferenceOptional = conferenceRepository.findById(conference.getEventId());
		assertTrue(conferenceOptional.isPresent());
	}

	@Test
	public void saveExposition_expositionAndGuests_correctSave() {
		Exposition exposition = new Exposition(LocalDate.of(2025, 6, 15), 90, "Barcelona", "Exposition Test");

		Guest guest1 = new Guest("Diego", Status.ATTENDING, exposition);
		Guest guest2 = new Guest("Alejandro", Status.NOT_ATTENDING, exposition);
		Guest guest3 = new Guest("Sara", Status.NO_RESPONSE, exposition);
		exposition.getGuests().add(guest1);
		exposition.getGuests().add(guest2);
		exposition.getGuests().add(guest3);

		expositionRepository.save(exposition);
		guestRepository.save(guest1);
		guestRepository.save(guest2);
		guestRepository.save(guest3);

		Optional<Exposition> expositionOptional = expositionRepository.findById(exposition.getEventId());
		assertTrue(expositionOptional.isPresent());
	}


}
