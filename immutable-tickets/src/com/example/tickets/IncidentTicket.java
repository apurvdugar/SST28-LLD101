package com.example.tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;         // e.g. "CLI", "WEBHOOK", "EMAIL"

    // public IncidentTicket() {
    //     this.tags = new ArrayList<>();
    // }

    // public IncidentTicket(String id, String reporterEmail, String title) {
    //     this();
    //     this.id = id;
    //     this.reporterEmail = reporterEmail;
    //     this.title = title;
    // }

    // public IncidentTicket(String id, String reporterEmail, String title, String priority) {
    //     this(id, reporterEmail, title);
    //     this.priority = priority;
    // }

    public IncidentTicket(Builder b) {
        this.id = b.id;
        this.reporterEmail = b.reporterEmail;
        this.title = b.title;
        this.description = b.description;
        this.priority = b.priority;
        this.tags = Collections.unmodifiableList(new ArrayList<>(b.tags)); // deep copy 
        this.assigneeEmail = b.assigneeEmail;
        this.customerVisible = b.customerVisible; 
        this.slaMinutes = b.slaMinutes;
        this.source = b.source;
    }

    public static Builder builder(String id, String reporterEmail, String title) {
        return new Builder(id, reporterEmail, title);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private String id;
        private String reporterEmail;
        private String title;

        private String description;
        private String priority;      
        private List<String> tags;    
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;    
        private String source;    

        public Builder(String id, String reporterEmail, String title) {
            this.id = id;
            this.reporterEmail = reporterEmail;
            this.title = title;
        }

        private Builder(IncidentTicket t) {
            this.id = t.id;
            this.reporterEmail = t.reporterEmail;
            this.title = t.title;
            this.description = t.description;
            this.priority = t.priority;
            this.tags = new ArrayList<>(t.tags);
            this.assigneeEmail = t.assigneeEmail;
            this.customerVisible = t.customerVisible;
            this.slaMinutes = t.slaMinutes;
            this.source = t.source;
        }

        public Builder setId(String id) { this.id = id; return this;}
        public Builder setReporterEmail(String reporterEmail) { this.reporterEmail = reporterEmail; return this;}
        public Builder setTitle(String title) { this.title = title; return this;}
        public Builder setDescription(String description) { this.description = description; return this;}
        public Builder setPriority(String priority) { this.priority = priority; return this;}
        public Builder setTags(List<String> tags) { this.tags = new ArrayList<>(tags); return this;}
        public Builder setAssigneeEmail(String assigneeEmail) { this.assigneeEmail = assigneeEmail; return this;}
        public Builder setCustomerVisible(boolean customerVisible) { this.customerVisible = customerVisible; return this;}
        public Builder setSlaMinutes(Integer slaMinutes) { this.slaMinutes = slaMinutes; return this;}
        public Builder setSource(String source) { this.source = source; return this;}
        public Builder addTag(String tag) {
            if (this.tags == null) {
                this.tags = new ArrayList<>();
            }
            this.tags.add(tag);
            return this;
        }

        public IncidentTicket build() {
            Validation.requireTicketId(this.id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireTitle(title);
            if (assigneeEmail != null) {
                Validation.requireEmail(assigneeEmail, "assigneeEmail");
            }
            if (priority != null) {
                Validation.validatePriority(priority);
            }
            if (slaMinutes != null) {
                Validation.validateSlaMinutes(slaMinutes);
            }
            return new IncidentTicket(this);
        }
    }

    // Getters
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return Collections.unmodifiableList(tags); } 
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }
}
