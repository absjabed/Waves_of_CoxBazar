package com.parvez_n_jabed_co.waves_of_coxbazar;

/**
 * Created by abs pc1 on 2017-05-19.
 */

public class Hotels {
  private  String id, hotel_name,hotel_logo_name,hotel_email,hotel_phone_number,status;

    public Hotels(String id, String hotel_name, String hotel_email, String hotel_phone_number, String hotel_logo_name) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_email = hotel_email;
        this.hotel_phone_number = hotel_phone_number;
        this.hotel_logo_name = hotel_logo_name;
    }

    public Hotels(String id, String hotel_name, String hotel_logo_name, String hotel_email, String hotel_phone_number, String status) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_logo_name = hotel_logo_name;
        this.hotel_email = hotel_email;
        this.hotel_phone_number = hotel_phone_number;
        this.status = status;
    }

    public Hotels(String id, String hotel_name, String hotel_email, String hotel_phone_number) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_email = hotel_email;
        this.hotel_phone_number = hotel_phone_number;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotel_logo_name() {
        return hotel_logo_name;
    }

    public void setHotel_logo_name(String hotel_logo_name) {
        this.hotel_logo_name = hotel_logo_name;
    }

    public String getHotel_email() {
        return hotel_email;
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }

    public String getHotel_phone_number() {
        return hotel_phone_number;
    }

    public void setHotel_phone_number(String hotel_phone_number) {
        this.hotel_phone_number = hotel_phone_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
