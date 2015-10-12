package com.bojie.currencycoverter;

/**
 * Created by bojiejiang on 10/11/15.
 */
public class CurrencyRate {

    /**
     * base : USD
     * date : 2015-10-09
     * rates : {"AUD":1.3644,"BGN":1.7214,"BRL":3.7494,"CAD":1.2936,"CHF":0.96101,"CNY":6.3452,"CZK":23.859,"DKK":6.5657,"GBP":0.65191,"HKD":7.7501,"HRK":6.7145,"HUF":274.24,"IDR":13507,"ILS":3.8242,"INR":64.8,"JPY":120.27,"KRW":1142.4,"MXN":16.394,"MYR":4.1295,"NOK":8.0879,"NZD":1.493,"PHP":45.718,"PLN":3.7115,"RON":3.8858,"RUB":61.049,"SEK":8.1573,"SGD":1.3954,"THB":35.55,"TRY":2.902,"ZAR":13.261,"EUR":0.88013}
     */

    private String base;
    private String date;
    private RatesEntity rates;



    public CurrencyRate() {
    }

    public CurrencyRate(String base, String date, RatesEntity rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRates(RatesEntity rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public RatesEntity getRates() {
        return rates;
    }

    public static class RatesEntity {
        /**
         * AUD : 1.3644
         * BGN : 1.7214
         * BRL : 3.7494
         * CAD : 1.2936
         * CHF : 0.96101
         * CNY : 6.3452
         * CZK : 23.859
         * DKK : 6.5657
         * GBP : 0.65191
         * HKD : 7.7501
         * HRK : 6.7145
         * HUF : 274.24
         * IDR : 13507
         * ILS : 3.8242
         * INR : 64.8
         * JPY : 120.27
         * KRW : 1142.4
         * MXN : 16.394
         * MYR : 4.1295
         * NOK : 8.0879
         * NZD : 1.493
         * PHP : 45.718
         * PLN : 3.7115
         * RON : 3.8858
         * RUB : 61.049
         * SEK : 8.1573
         * SGD : 1.3954
         * THB : 35.55
         * TRY : 2.902
         * ZAR : 13.261
         * EUR : 0.88013
         */

        private double AUD;
        private double BGN;
        private double BRL;
        private double CAD;
        private double CHF;
        private double CNY;
        private double CZK;
        private double DKK;
        private double GBP;
        private double HKD;
        private double HRK;
        private double HUF;
        private int IDR;
        private double ILS;
        private double INR;
        private double JPY;
        private double KRW;
        private double MXN;
        private double MYR;
        private double NOK;
        private double NZD;
        private double PHP;
        private double PLN;
        private double RON;
        private double RUB;
        private double SEK;
        private double SGD;
        private double THB;
        private double TRY;
        private double ZAR;
        private double EUR;

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public void setCHF(double CHF) {
            this.CHF = CHF;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public void setDKK(double DKK) {
            this.DKK = DKK;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public void setHKD(double HKD) {
            this.HKD = HKD;
        }

        public void setHRK(double HRK) {
            this.HRK = HRK;
        }

        public void setHUF(double HUF) {
            this.HUF = HUF;
        }

        public void setIDR(int IDR) {
            this.IDR = IDR;
        }

        public void setILS(double ILS) {
            this.ILS = ILS;
        }

        public void setINR(double INR) {
            this.INR = INR;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public void setKRW(double KRW) {
            this.KRW = KRW;
        }

        public void setMXN(double MXN) {
            this.MXN = MXN;
        }

        public void setMYR(double MYR) {
            this.MYR = MYR;
        }

        public void setNOK(double NOK) {
            this.NOK = NOK;
        }

        public void setNZD(double NZD) {
            this.NZD = NZD;
        }

        public void setPHP(double PHP) {
            this.PHP = PHP;
        }

        public void setPLN(double PLN) {
            this.PLN = PLN;
        }

        public void setRON(double RON) {
            this.RON = RON;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public void setSEK(double SEK) {
            this.SEK = SEK;
        }

        public void setSGD(double SGD) {
            this.SGD = SGD;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public void setZAR(double ZAR) {
            this.ZAR = ZAR;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }

        public double getAUD() {
            return AUD;
        }

        public double getBGN() {
            return BGN;
        }

        public double getBRL() {
            return BRL;
        }

        public double getCAD() {
            return CAD;
        }

        public double getCHF() {
            return CHF;
        }

        public double getCNY() {
            return CNY;
        }

        public double getCZK() {
            return CZK;
        }

        public double getDKK() {
            return DKK;
        }

        public double getGBP() {
            return GBP;
        }

        public double getHKD() {
            return HKD;
        }

        public double getHRK() {
            return HRK;
        }

        public double getHUF() {
            return HUF;
        }

        public int getIDR() {
            return IDR;
        }

        public double getILS() {
            return ILS;
        }

        public double getINR() {
            return INR;
        }

        public double getJPY() {
            return JPY;
        }

        public double getKRW() {
            return KRW;
        }

        public double getMXN() {
            return MXN;
        }

        public double getMYR() {
            return MYR;
        }

        public double getNOK() {
            return NOK;
        }

        public double getNZD() {
            return NZD;
        }

        public double getPHP() {
            return PHP;
        }

        public double getPLN() {
            return PLN;
        }

        public double getRON() {
            return RON;
        }

        public double getRUB() {
            return RUB;
        }

        public double getSEK() {
            return SEK;
        }

        public double getSGD() {
            return SGD;
        }

        public double getTHB() {
            return THB;
        }

        public double getTRY() {
            return TRY;
        }

        public double getZAR() {
            return ZAR;
        }

        public double getEUR() {
            return EUR;
        }
    }
}
