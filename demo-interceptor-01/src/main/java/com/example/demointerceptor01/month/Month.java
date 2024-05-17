package com.example.demointerceptor01.month;
public class Month {
    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }


    public static final class MonthBuilder {
        private Integer monthNumber;
        private String englishName;
        private String italianName;
        private String germanName;

        private MonthBuilder() {
        }

        public static MonthBuilder aMonth() {
            return new MonthBuilder();
        }

        public MonthBuilder withMonthNumber(Integer monthNumber) {
            this.monthNumber = monthNumber;
            return this;
        }

        public MonthBuilder withEnglishName(String englishName) {
            this.englishName = englishName;
            return this;
        }

        public MonthBuilder withItalianName(String italianName) {
            this.italianName = italianName;
            return this;
        }

        public MonthBuilder withGermanName(String germanName) {
            this.germanName = germanName;
            return this;
        }

        public Month build() {
            Month month = new Month();
            month.setMonthNumber(monthNumber);
            month.setEnglishName(englishName);
            month.setItalianName(italianName);
            month.setGermanName(germanName);
            return month;
        }
    }
}
