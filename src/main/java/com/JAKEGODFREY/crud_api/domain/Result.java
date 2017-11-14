package com.JAKEGODFREY.crud_api.domain;

    public class Result {

        private String timeDate;
        private String userID;
        private String userName;

        /**
         * empty constructor
         */
        public Result(){}

        public Result(String timeDate, String userID, String userName) {
            this.timeDate = timeDate;
            this.userID = userID;
            this.userName = userName;
        }


        public String getTimeDate() {
            return timeDate;
        }

        public void setTimeDate(String timeDate) {
            this.timeDate = timeDate;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString(){
            return "The result: [Date and time of result: " + timeDate
                    + "\n User's ID: " + userID + "\n User's name: " + userName + " ]";
        }
    }
