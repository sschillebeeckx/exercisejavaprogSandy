package be.abis.courseadmin.service;

import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AbisEnrolmentService implements EnrolmentService {
    @Override
    public List<CourseParticipant> sortParticipantsByPersonNumber(List<CourseParticipant> participants) {
        Collections.sort(participants);
        return participants;
    }

    @Override
    public List<CourseParticipant> sortParticipantsByFirstName(List<CourseParticipant> participants) {
        participants.sort((p1, p2) -> ((Person) p1).getFirstName().compareTo(((Person) p2).getFirstName()));
        return participants;
    }

    @Override
    public List<CourseParticipant> sortParticipantsByLastName(List<CourseParticipant> participants) {
        participants.sort((p1, p2) -> ((Person) p1).getLastName().compareTo(((Person) p2).getLastName()));
        return participants;
    }

    @Override
    public List<CourseParticipant> sortParticipantsByLastandFirstName(List<CourseParticipant> participants) {
        participants.sort(Comparator.comparing(c -> ((Person) c).getLastName()).thenComparing(c -> ((Person) c).getFirstName()));
        return participants;
    }

}

