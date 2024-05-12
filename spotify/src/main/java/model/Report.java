package model;

import model.userAcc.Artist.Artist;
import model.userAcc.User;

public class Report {
    private User reporterUser;
    private Artist reportedArtist;
    private String description;

    public User getReporterUser() {
        return reporterUser;
    }

    public void setReporterUser(User reporterUser) {
        this.reporterUser = reporterUser;
    }

    public Artist getReportedArtist() {
        return reportedArtist;
    }

    public void setReportedArtist(Artist reportedArtist) {
        this.reportedArtist = reportedArtist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Report(User reporterUser, Artist reportedArtist, String description) {
        this.reporterUser = reporterUser;
        this.reportedArtist = reportedArtist;
        this.description = description;
    }
}
