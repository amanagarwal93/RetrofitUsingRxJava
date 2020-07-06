package com.example.retrofitrxjava.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<UserData> data = null;

    /**
     * No args constructor for use in serialization
     */
    public ResponseData() {
    }

    /**
     * @param data
     * @param status
     */
    public ResponseData(String status, List<UserData> data) {
        super();
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }

    public class UserData {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("employee_name")
        @Expose
        private String employeeName;
        @SerializedName("employee_salary")
        @Expose
        private String employeeSalary;
        @SerializedName("employee_age")
        @Expose
        private String employeeAge;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;

        /**
         * No args constructor for use in serialization
         */
        public UserData() {
        }

        /**
         * @param employeeName
         * @param employeeAge
         * @param id
         * @param profileImage
         * @param employeeSalary
         */
        public UserData(String id, String employeeName, String employeeSalary, String employeeAge, String profileImage) {
            super();
            this.id = id;
            this.employeeName = employeeName;
            this.employeeSalary = employeeSalary;
            this.employeeAge = employeeAge;
            this.profileImage = profileImage;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeSalary() {
            return employeeSalary;
        }

        public void setEmployeeSalary(String employeeSalary) {
            this.employeeSalary = employeeSalary;
        }

        public String getEmployeeAge() {
            return employeeAge;
        }

        public void setEmployeeAge(String employeeAge) {
            this.employeeAge = employeeAge;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

    }
}
