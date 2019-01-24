package com.example.mosta.pager;

public class Patient {
    private Integer mPatientPic = R.drawable.asset_unknown;
    private String mPatientName;
    private Integer mGender;
    private Integer mAge;
    private Integer mWeight;
    private Integer mHB;
    private String mTemp;
    private Integer mBP;
    private Integer mSeverity = 0;
    private String mAddress;
    private String mPhoneNumber;

    public Patient(Integer patientPic, String patientName, int patientGender, int patientAge, int patientWeight, int patientHeartBeat, String patientTemp, int patientBloodPressure) {
        mPatientPic = patientPic;
        mPatientName = patientName;
        mAge = patientAge;
        mBP = patientBloodPressure;
        mGender = patientGender;
        mWeight = patientWeight;
        mHB = patientHeartBeat;
        mTemp = patientTemp;

        if (patientBloodPressure >= 140 || patientHeartBeat >= 160 || patientBloodPressure <= 40  || patientHeartBeat <= 30) {
            mSeverity = 2;
        } else if (patientBloodPressure >= 130 || patientHeartBeat >= 120 || patientBloodPressure <= 90 || patientHeartBeat <= 50) {
            mSeverity = 1;
        } else {
            mSeverity = 0;
        }

    }

    public Patient(String patientName, int patientGender, int patientAge, int patientWeight, int patientHeartBeat, String patientTemp, int patientBloodPressure) {
        mPatientName = patientName;
        mAge = patientAge;
        mBP = patientBloodPressure;
        mGender = patientGender;
        mWeight = patientWeight;
        mHB = patientHeartBeat;
        mTemp = patientTemp;
        if (patientBloodPressure > 140 ||  patientHeartBeat > 160 || patientBloodPressure < 40 ||  patientHeartBeat < 30) {
            mSeverity = 2;
        } else if (patientBloodPressure > 130 ||  patientHeartBeat > 120 || patientBloodPressure < 90 || patientHeartBeat < 50) {
            mSeverity = 1;
        } else {
            mSeverity = 0;
        }




    }
        public Patient(Integer patientPic, String patientName, int patientGender, int patientAge, int patientWeight, int patientHeartBeat, String patientTemp, int patientBloodPressure, String patientTelephone, String patientAddress) {
        mPatientPic = patientPic;
        mPatientName = patientName;
        mAge = patientAge;
        mBP = patientBloodPressure;
        mGender = patientGender;
        mWeight = patientWeight;
        mHB = patientHeartBeat;
        mTemp = patientTemp;
        mAddress = patientAddress;
        mPhoneNumber = patientTelephone;
        if (patientBloodPressure >= 140 ||  patientHeartBeat >= 160 || patientBloodPressure <= 40 ||  patientHeartBeat <= 30) {
            mSeverity = 2;
        } else if (patientBloodPressure >= 130 || patientHeartBeat >= 120 || patientBloodPressure <= 90 ||  patientHeartBeat <= 50) {
            mSeverity = 1;
        } else {
            mSeverity = 0;
        }

    }

    public Integer getmPatientPic() {
        return mPatientPic;
    }

    public void setmPatientPic(Integer mPatientPic) {
        this.mPatientPic = mPatientPic;
    }

    public String getmPatientName() {
        return mPatientName;
    }

    public void setmPatientName(String mPatientName) {
        this.mPatientName = mPatientName;
    }

    public int getmGender() {
        return mGender;
    }

    public void setmGender(int mGender) {
        this.mGender = mGender;
    }

    public String getmAge() {
        return mAge.toString();
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmWeight() {
        return mWeight.toString();
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public String getmHB() {
        return mHB.toString();
    }

    public void setmHB(int mHB) {
        this.mHB = mHB;
    }

    public String getmTemp() {
        return mTemp.toString();
    }

    public String getmBP() {
        return mBP.toString();
    }

    public void setmBP(int mBP) {
        this.mBP = mBP;
    }

    public Integer getmSeverity() {
        return mSeverity;
    }

    public void setmSeverity(Integer mSeverity) {
        this.mSeverity = mSeverity;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
}

