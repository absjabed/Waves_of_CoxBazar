package com.parvez_n_jabed_co.waves_of_coxbazar;

/**
 * Created by PARVEZ on 08-Oct-16.
 */
public class JetshiItem {

        private String jetname;
        private String mobilenumber ;
        public JetshiItem(String jetname, String mobilenumber) {
            super();
            this.jetname = jetname;
            this.mobilenumber = mobilenumber;
        }
    public JetshiItem(String jetname) {
        super();
        this.jetname = jetname;

    }
        public String getJetname() {
            return jetname;
        }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setJetname(String jetname) {
        this.jetname = jetname;
    }

    public void setMobilenumber(String mobilenumber) {
            this.mobilenumber = mobilenumber;
        }



    }
