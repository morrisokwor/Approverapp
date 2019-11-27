package co.ke.bsl.ui.activities;

public class MyData {
     private String notice;
     private  String message;

    public MyData() {
    }


    public String getNotice() {
        return notice;
    }

    public String getMessage() {
        return message;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyData(String notice, String message) {
        this.notice = notice;
        this.message = message;
    }

}
