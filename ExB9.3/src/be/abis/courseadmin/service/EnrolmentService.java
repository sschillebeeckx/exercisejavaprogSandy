package be.abis.courseadmin.service;

import be.abis.courseadmin.model.CourseParticipant;

import java.util.List;

public interface EnrolmentService {

    List<CourseParticipant> sortParticipantsByPersonNumber(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByFirstName(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByLastName(List<CourseParticipant> participants);
    List<CourseParticipant> sortParticipantsByLastandFirstName(List<CourseParticipant> participants);

}
