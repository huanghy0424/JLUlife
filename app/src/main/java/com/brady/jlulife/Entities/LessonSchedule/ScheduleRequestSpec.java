package com.brady.jlulife.Entities.LessonSchedule;

/**
 * Created by brady on 15-11-8.
 */
public class ScheduleRequestSpec {
    private int termId;
    private int studId;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }
}
